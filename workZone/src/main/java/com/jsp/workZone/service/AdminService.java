package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.AdminDao;
import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.exceptionhandlerforworkzone.AdminNotFound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {

		Admin dbAdmin = adminDao.saveAdmin(admin);
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setData(dbAdmin);
		structure.setMsg("Data saved successfully....");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Admin>> findAdminById(int id) {
		Admin dbAdmin = adminDao.findAdminById(id);

		if (dbAdmin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setMsg("Admin id " + id + " found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dbAdmin);

			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new AdminNotFound("Admin is not there with id " + id);
		}
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		
		Admin dbAdmin = adminDao.findAdminById(admin.getId());

		if (dbAdmin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<>();
			structure.setMsg("Admin updated successfully.");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(adminDao.updateAdmin(admin));

			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.FOUND);
		} else {
			throw new AdminNotFound("Admin does not exist");
		}
	} 

}
