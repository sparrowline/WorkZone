package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class NoFloorsFound extends RuntimeException {
	
	private String msg="floor is not there in our database.";

	public NoFloorsFound(String msg) {
		super();
		this.msg = msg;
	}

	public NoFloorsFound() {
		super();
	}
	
	

}
