package com.travix.medusa.busyflights.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.constants.SupplierConstants;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.supplier.service.SupplierFactory;
import com.travix.medusa.busyflights.supplier.service.SupplierService;

@Service
public class BusyFlightsService {
	
	@Autowired
	private SupplierFactory supFactory;
	
	public List<BusyFlightsResponse> getAggregatedResult(BusyFlightsRequest request){
		List<BusyFlightsResponse>  finalresponse  = new ArrayList<BusyFlightsResponse>();
		for(String supplierId : SupplierConstants.SUPPLIER_ARRAY) {
			SupplierService supplierService = supFactory.getSupplier(supplierId);
			List<BusyFlightsResponse>  supplierResponse = supplierService.getSupplierResponse(request);
			finalresponse.addAll(supplierResponse);	
		}
		
		return finalresponse;
	}
}
