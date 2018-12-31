package com.travix.medusa.busyflights.domain.toughjet;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class ToughJetRequest {
	
	@ApiModelProperty(required = true)
	@NotNull
	@Size(min = 3, max = 3)
    private String from;
	
	@ApiModelProperty(required = true)
	@NotNull
	@Size(min = 3, max = 3)
    private String to;
	
	@ApiModelProperty(required = true, value = "date should be in format 'yyyy-MM-dd'")
	@NotNull
	@Pattern(regexp = "^((20|21)\\\\d\\\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")
    private String outboundDate;
	
	@ApiModelProperty(required = true, value = "date should be in format 'yyyy-MM-dd'")
	@NotNull
	@Pattern(regexp = "^((20|21)\\\\d\\\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")
    private String inboundDate;
	
	@ApiModelProperty(required = true)
	@NotNull
	@Max(4)
    private int numberOfAdults;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getOutboundDate() {
		return outboundDate;
	}

	public void setOutboundDate(String outboundDate) {
		this.outboundDate = outboundDate;
	}

	public String getInboundDate() {
		return inboundDate;
	}

	public void setInboundDate(String inboundDate) {
		this.inboundDate = inboundDate;
	}

	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
}
