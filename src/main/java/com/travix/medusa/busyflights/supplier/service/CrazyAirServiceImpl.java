package com.travix.medusa.busyflights.supplier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

@Service
public class CrazyAirServiceImpl implements SupplierService {

	private String uri = "http://localhost:8080/api/crazyair/flights";

	@Override
	public List<BusyFlightsResponse> getSupplierResponse(BusyFlightsRequest request) {
		List<BusyFlightsResponse> response = new ArrayList<BusyFlightsResponse>();

		CrazyAirRequest caRequest = buildCrazyAirRequest(request);
		// List<CrazyAirResponse> caResponse = getFlightsFromCrazyAir(caRequest);
		CrazyAirResponse[] caResponse = getFlightsFromCrazyAir(caRequest);
		response = buildBusyFlightResponse(caResponse);

		return response;
	}

	private CrazyAirRequest buildCrazyAirRequest(BusyFlightsRequest request) {

		CrazyAirRequest caRequest = new CrazyAirRequest();
		caRequest.setOrigin(request.getOrigin());
		caRequest.setDestination(request.getDestination());
		caRequest.setDepartureDate(request.getDepartureDate());
		caRequest.setReturnDate(request.getReturnDate());
		caRequest.setPassengerCount(request.getNumberOfPassengers());

		return caRequest;
	}

	private CrazyAirResponse[] getFlightsFromCrazyAir(CrazyAirRequest request) {

		RestTemplate restTemplate = new RestTemplate();
		CrazyAirResponse[] result = restTemplate.postForObject(uri, request, CrazyAirResponse[].class);
		return result;
	}

	private List<BusyFlightsResponse> buildBusyFlightResponse(CrazyAirResponse[] caResponseArr) {
		List<BusyFlightsResponse> response = new ArrayList<BusyFlightsResponse>();

		for (CrazyAirResponse caResponse : caResponseArr) {
			BusyFlightsResponse bfResponse = new BusyFlightsResponse();
			bfResponse.setAirline(caResponse.getAirline());
			bfResponse.setArrivalDate(caResponse.getArrivalDate());
			bfResponse.setDepartureAirportCode(caResponse.getDepartureAirportCode());
			bfResponse.setDepartureDate(caResponse.getDepartureDate());
			bfResponse.setDestinationAirportCode(caResponse.getDestinationAirportCode());
			bfResponse.setFare(caResponse.getPrice());
			bfResponse.setSupplier("Crazy Air");
			response.add(bfResponse);
		}

		return response;
	}
}
