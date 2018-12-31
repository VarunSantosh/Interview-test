package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class BusyFlightsResponse {

	@ApiModelProperty()
	@NotNull
	private String airline;

	@ApiModelProperty()
	@NotNull
	private String supplier;

	@ApiModelProperty()
	@NotNull
	private Double fare;

	@ApiModelProperty(required = true)
	@NotNull
	private String departureAirportCode;

	@ApiModelProperty(required = true)
	@NotNull
	private String destinationAirportCode;

	@ApiModelProperty(required = true)
	@NotNull
	private String departureDate;

	@ApiModelProperty(required = true)
	@NotNull
	private String arrivalDate;

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
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
