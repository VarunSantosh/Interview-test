package com.travix.medusa.busyflights.domain.crazyair;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class CrazyAirResponse {

	@ApiModelProperty()
	@NotNull
	private String airline;

	@ApiModelProperty()
	@NotNull
	private double price;

	@ApiModelProperty()
	@NotNull
	private String cabinclass;

	@ApiModelProperty()
	@NotNull
	private String departureAirportCode;

	@ApiModelProperty()
	@NotNull
	private String destinationAirportCode;

	@ApiModelProperty()
	@NotNull
	private String departureDate;

	@ApiModelProperty()
	@NotNull
	private String arrivalDate;

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCabinclass() {
		return cabinclass;
	}

	public void setCabinclass(String cabinclass) {
		this.cabinclass = cabinclass;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	
}
