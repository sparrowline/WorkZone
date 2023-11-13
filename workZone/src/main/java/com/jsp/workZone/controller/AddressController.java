package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.Address;
import com.jsp.workZone.service.AddressService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PutMapping("/updateaddress")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address) {
		return addressService.updateAddres(address);
	}
	
	@GetMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> findAddressById(@RequestParam int id) {
		return addressService.findAddressById(id);
	}

}
