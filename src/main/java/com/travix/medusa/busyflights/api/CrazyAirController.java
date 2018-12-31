package com.travix.medusa.busyflights.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.validator.DateValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/crazyair")
public class CrazyAirController {

	@ApiOperation(value = "Gets the aggregated results from mulitple supplier", nickname = "Busy Flights api", response = CrazyAirResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Request Processed Successfully", response = CrazyAirResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"), 
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/flights", 
	produces = { "application/json" }, 
	consumes = {"application/json" }, 
	method = RequestMethod.POST)
	public ResponseEntity<List<CrazyAirResponse>> getFlights(@Valid @RequestBody CrazyAirRequest request, Errors errors) {
		
		if (!(DateValidator.isDateValid(errors, request.getDepartureDate()) && DateValidator.isDateValid(errors, request.getReturnDate()))) {
			return new ResponseEntity<List<CrazyAirResponse>>(HttpStatus.BAD_REQUEST);
		}
		
		List<CrazyAirResponse> list = new ArrayList<CrazyAirResponse>();
		
		CrazyAirResponse ongoingResponse = new CrazyAirResponse();
		ongoingResponse.setAirline("Fly Emirates");
		ongoingResponse.setCabinclass("E");
		ongoingResponse.setDepartureAirportCode(request.getOrigin());
		ongoingResponse.setDestinationAirportCode(request.getDestination());
		ongoingResponse.setPrice(1200.00);
		ongoingResponse.setDepartureDate(request.getDepartureDate()+"T14:30:15.312");//TODO date formatting, hard coded for now
		ongoingResponse.setArrivalDate(request.getDepartureDate()+"T16:30:15.312"); // TODO date formatting, hard coded for now
		
		CrazyAirResponse returnResponse = new CrazyAirResponse();
		returnResponse.setAirline("Fly Emirates");
		returnResponse.setCabinclass("E");
		returnResponse.setDepartureAirportCode(request.getDestination());
		returnResponse.setDestinationAirportCode(request.getOrigin());
		returnResponse.setPrice(1200.00);
		returnResponse.setDepartureDate(request.getReturnDate()+"T14:30:15.312");//TODO date formatting, hard coded for now
		returnResponse.setArrivalDate(request.getReturnDate()+"T16:30:15.312"); // TODO date formatting, hard coded for now
		
		list.add(ongoingResponse);
		list.add(returnResponse);
	
		return new ResponseEntity<List<CrazyAirResponse>>(list, HttpStatus.OK);

	}

}
