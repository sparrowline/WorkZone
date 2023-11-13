package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.service.AdminService;
import com.jsp.workZone.util.ResponseStructure;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/saveadmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		
		return adminService.saveAdmin(admin);
		
	}
	
	@RequestMapping("/findadminbyid")
	public ResponseEntity<ResponseStructure<Admin>> findAdminById(@RequestParam int id){
		return adminService.findAdminById(id);
	}
	
	@PutMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}
	

}
