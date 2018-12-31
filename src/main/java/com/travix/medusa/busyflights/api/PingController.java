package com.travix.medusa.busyflights.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PingController {
	
	@ApiOperation(value = "To check if the server is up and running. ", response = String.class, tags = {})
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Server is up and running", response = String.class),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {

		return "Server OK";
	}

}
