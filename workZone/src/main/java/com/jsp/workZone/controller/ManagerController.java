package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.service.ManagerService;
import com.jsp.workZone.util.ResponseStructure;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/saveManager")
	public ResponseEntity<ResponseStructure<Manager>> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

}
