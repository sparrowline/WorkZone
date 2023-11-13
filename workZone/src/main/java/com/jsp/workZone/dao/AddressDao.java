package com.jsp.workZone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Address;
import com.jsp.workZone.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepo addressRepo;

	public Address updateAddress(Address address) {

		if (addressRepo.findById(address.getId()).isPresent()) {
			Address db = addressRepo.findById(address.getId()).get();

			if (address.getCity() == null) {
				address.setCity(db.getCity());
			}
			if (address.getDistrict() == null) {
				address.setDistrict(db.getDistrict());
			}
			if (address.getDoor_No() == null) {
				address.setDoor_No(db.getDoor_No());
			}
			if (address.getLandmark() == null) {
				address.setLandmark(db.getLandmark());
			}
			if (address.getPincode() == 0) {
				address.setPincode(db.getPincode());
			}
			if (address.getState() == null) {
				address.setState(db.getState());
			}
			if (address.getStreet() == null) {
				address.setStreet(db.getStreet());
			}
			return addressRepo.save(address);
		}
		return null;

	}

	public Address findAddressById(int id) {

		if (addressRepo.findById(id).isPresent()) {
			Address db = addressRepo.findById(id).get();
			return db;

		} else
			return null;
	}

}
