package com.travix.medusa.busyflights.domain.crazyair;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class CrazyAirRequest {
	
	@ApiModelProperty(required = true)
	@NotNull
	@Size(min = 3, max = 3)
    private String origin;
	
	@ApiModelProperty(required = true)
	@NotNull
	@Size(min = 3, max = 3)
    private String destination;
	
	@ApiModelProperty(required = true, value = "date should be in format 'yyyy-MM-dd'")
	@NotNull
	@Pattern(regexp = "^((20|21)\\\\d\\\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")
    private String departureDate;
	
	@ApiModelProperty(required = true, value = "date should be in format 'yyyy-MM-dd'")
	@NotNull
	@Pattern(regexp = "^((20|21)\\\\d\\\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")
    private String returnDate;
	
	@ApiModelProperty(required = true)
	@NotNull
	@Max(4)
    private int passengerCount;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
}
