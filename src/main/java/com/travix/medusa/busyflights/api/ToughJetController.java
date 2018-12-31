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

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.validator.DateValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/toughjet")
public class ToughJetController {
	
	@ApiOperation(value = "Gets the aggregated results from mulitple supplier", nickname = "Busy Flights api", response = ToughJetResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Request Processed Successfully", response = ToughJetResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"), 
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/flights", 
	produces = { "application/json" }, 
	consumes = {"application/json" }, 
	method = RequestMethod.POST)
	public ResponseEntity<List<ToughJetResponse>> getFlights(@Valid @RequestBody ToughJetRequest request, Errors errors) {
		
		if (!(DateValidator.isDateValid(errors, request.getInboundDate()) && DateValidator.isDateValid(errors, request.getOutboundDate()))) {
			return new ResponseEntity<List<ToughJetResponse>>(HttpStatus.BAD_REQUEST);
		}

		List<ToughJetResponse> list = new ArrayList<ToughJetResponse>();
		
		ToughJetResponse onwardsresponse = new ToughJetResponse();
		onwardsresponse.setCarrier("Fly Emirates");
		onwardsresponse.setBasePrice(1200);
		onwardsresponse.setDiscount(100);
		onwardsresponse.setTax(12);
		onwardsresponse.setDepartureAirportName(request.getFrom());
		onwardsresponse.setArrivalAirportName(request.getTo());
		onwardsresponse.setInboundDateTime(request.getInboundDate()+"T14:30:15.312Z");//TODO date formatting, hard coded for now
		onwardsresponse.setOutboundDateTime(request.getInboundDate()+"T16:30:15.312Z"); // TODO date formatting, hard coded for now
		
		ToughJetResponse returnresponse = new ToughJetResponse();
		returnresponse.setCarrier("Fly Emirates");
		returnresponse.setBasePrice(1200);
		returnresponse.setDiscount(100);
		returnresponse.setTax(12);
		returnresponse.setDepartureAirportName(request.getTo());
		returnresponse.setArrivalAirportName(request.getFrom());
		returnresponse.setInboundDateTime(request.getOutboundDate()+"T14:30:15.312Z");//TODO date formatting
		returnresponse.setOutboundDateTime(request.getOutboundDate()+"T16:30:15.312Z"); // TODO date formatting
		
		list.add(onwardsresponse);
		list.add(returnresponse);
	
		return new ResponseEntity<List<ToughJetResponse>>(list, HttpStatus.OK);

	}


}
