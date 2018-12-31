package com.travix.medusa.busyflights.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import com.travix.medusa.busyflights.validator.DateValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/busyflights")
public class BusyFlightsController {
	
	@Autowired
	private BusyFlightsService service;

	@ApiOperation(value = "Gets the aggregated results from mulitple supplier", nickname = "Busy Flights api", response = BusyFlightsResponse.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Request Processed Successfully", response = BusyFlightsResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"), 
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden"), 
			@ApiResponse(code = 404, message = "Resource Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/flights", 
	produces = { "application/json" }, 
	consumes = {"application/json" }, 
	method = RequestMethod.POST)
	public ResponseEntity<List<BusyFlightsResponse>> getFlights(@Valid @RequestBody BusyFlightsRequest request, Errors errors) {

		if (!(DateValidator.isDateValid(errors, request.getDepartureDate())
				&& DateValidator.isDateValid(errors, request.getReturnDate()))) {
			return new ResponseEntity<List<BusyFlightsResponse>>(HttpStatus.BAD_REQUEST);
		}

		try {
			List<BusyFlightsResponse> response = service.getAggregatedResult(request);
			if (response.size() == 0) {
				return new ResponseEntity<List<BusyFlightsResponse>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<List<BusyFlightsResponse>>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<BusyFlightsResponse>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
