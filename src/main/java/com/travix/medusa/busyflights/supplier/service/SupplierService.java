package com.travix.medusa.busyflights.supplier.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Service
public interface SupplierService {
	
	List<BusyFlightsResponse> getSupplierResponse(BusyFlightsRequest request);

}
