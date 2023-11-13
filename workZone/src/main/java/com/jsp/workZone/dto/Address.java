package com.jsp.workZone.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String  door_No;
	private String landmark;
	private String street;
	private String city;
	private String district;
	private String state;
	private int pincode;
	

}
