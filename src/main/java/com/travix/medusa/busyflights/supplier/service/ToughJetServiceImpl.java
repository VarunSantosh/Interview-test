package com.travix.medusa.busyflights.supplier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public class ToughJetServiceImpl implements SupplierService {

	private String uri = "http://localhost:8080/api/toughjet/flights";

	@Override
	public List<BusyFlightsResponse> getSupplierResponse(BusyFlightsRequest request) {
		List<BusyFlightsResponse> response = new ArrayList<BusyFlightsResponse>();

		com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest caRequest = buildToughJetRequest(request);
		ToughJetResponse[] caResponse = getFlightsFromToughJet(caRequest);
		response = buildBusyFlightResponse(caResponse);

		return response;
	}

	private ToughJetRequest buildToughJetRequest(BusyFlightsRequest request) {

		ToughJetRequest caRequest = new ToughJetRequest();
		caRequest.setFrom(request.getOrigin());
		caRequest.setTo(request.getDestination());
		caRequest.setInboundDate(request.getDepartureDate());
		caRequest.setOutboundDate(request.getReturnDate());
		caRequest.setNumberOfAdults(request.getNumberOfPassengers());

		return caRequest;
	}

	private ToughJetResponse[] getFlightsFromToughJet(ToughJetRequest request) {

		RestTemplate restTemplate = new RestTemplate();
		ToughJetResponse[] result = restTemplate.postForObject(uri, request, ToughJetResponse[].class);
		return result;
	}

	private List<BusyFlightsResponse> buildBusyFlightResponse(ToughJetResponse[] tjResponseArr) {
		List<BusyFlightsResponse> response = new ArrayList<BusyFlightsResponse>();

		for (ToughJetResponse tjResponse : tjResponseArr) {
			BusyFlightsResponse bfResponse = new BusyFlightsResponse();
			bfResponse.setAirline(tjResponse.getCarrier());
			bfResponse.setArrivalDate(tjResponse.getInboundDateTime());
			bfResponse.setDepartureAirportCode(tjResponse.getDepartureAirportName());
			bfResponse.setDepartureDate(tjResponse.getOutboundDateTime());
			bfResponse.setDestinationAirportCode(tjResponse.getArrivalAirportName());
			bfResponse.setFare((tjResponse.getBasePrice() + tjResponse.getTax() - tjResponse.getDiscount()));
			bfResponse.setSupplier("ToughJet");
			response.add(bfResponse);
		}
		return response;
	}
}
