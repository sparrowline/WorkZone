package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class NoAddressFound extends RuntimeException {
	
	private String msg= "Address not found!";

	public NoAddressFound(String msg) {
		super();
		this.msg = msg;
	}

	public NoAddressFound() {
		super();
	}
	

}
