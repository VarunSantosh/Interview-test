package com.travix.medusa.busyflights.domain.toughjet;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class ToughJetResponse {

	@ApiModelProperty()
	@NotNull
	private String carrier;

	@ApiModelProperty()
	@NotNull
	private double basePrice;

	@ApiModelProperty()
	private double tax;

	@ApiModelProperty()
	private double discount;

	@ApiModelProperty()
	@NotNull
	private String departureAirportName;

	@ApiModelProperty()
	@NotNull
	private String arrivalAirportName;

	@ApiModelProperty()
	@NotNull
	private String outboundDateTime;

	@ApiModelProperty()
	@NotNull
	private String inboundDateTime;

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public String getOutboundDateTime() {
		return outboundDateTime;
	}

	public void setOutboundDateTime(String outboundDateTime) {
		this.outboundDateTime = outboundDateTime;
	}

	public String getInboundDateTime() {
		return inboundDateTime;
	}

	public void setInboundDateTime(String inboundDateTime) {
		this.inboundDateTime = inboundDateTime;
	}
}
