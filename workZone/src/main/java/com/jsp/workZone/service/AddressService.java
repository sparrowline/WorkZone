package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.AddressDao;
import com.jsp.workZone.dto.Address;
import com.jsp.workZone.exceptionhandlerforworkzone.NoAddressFound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao addressDao;

	public ResponseEntity<ResponseStructure<Address>> updateAddres(Address address) {

		Address db = addressDao.updateAddress(address);
		if (db != null) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setData(db);
			structure.setMsg("Address updated successfully.");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
		} else
			throw new NoAddressFound("Address not found!");

	}
	
	public ResponseEntity<ResponseStructure<Address>> findAddressById(int id) {

		Address db = addressDao.findAddressById(id);
		if (db != null) {
			ResponseStructure<Address> structure = new ResponseStructure<>();
			structure.setData(db);
			structure.setMsg("Address found");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Address>>(structure, HttpStatus.CREATED);
		} else
			throw new NoAddressFound("Address not found!");

	}
	
}
