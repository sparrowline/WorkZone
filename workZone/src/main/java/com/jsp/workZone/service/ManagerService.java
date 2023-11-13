package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.AdminDao;
import com.jsp.workZone.dao.BuildingDao;
import com.jsp.workZone.dao.ManagerDao;
import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class ManagerService {

	@Autowired
	private ManagerDao managerDao;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		Manager dbManager = managerDao.saveManager(manager);
		ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
		structure.setData(dbManager);
		structure.setMsg("Manager Saved successfully...");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.CREATED);
	}

}
