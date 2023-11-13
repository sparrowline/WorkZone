package com.jsp.workZone.exceptionhandlerforworkzone;

import lombok.Data;

@Data
public class TypeNotFound extends RuntimeException {

	private String msg="Type does not exist";

	public TypeNotFound(String msg) {
		super();
		this.msg = msg;
	}

	public TypeNotFound() {
		super();
	}
	
}
