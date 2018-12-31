package com.travix.medusa.busyflights.supplier.service;

import org.springframework.stereotype.Component;

@Component
public class SupplierFactory {
	
	public SupplierService getSupplier(String identifier) {
		
		SupplierService service = null;
		
		switch (identifier) {
		case "CA":
			service = new CrazyAirServiceImpl();
			break;
		case "TJ":
			service = new ToughJetServiceImpl();
			break;
		default:
			break;
		}
		
		return service;
	}

}
