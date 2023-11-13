package com.jsp.workZone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.service.WorkSpaceService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class WokSpaceController {
	
	@Autowired
	private WorkSpaceService workSpaceService;
	
	@PostMapping("/saveworkspace")
	public ResponseEntity<ResponseStructure<WorkSpace>>  saveWorkSpace(@RequestParam int floorId,@RequestParam int managerId,@RequestBody WorkSpace workSpace) {
		return workSpaceService.saveWorkSpace(floorId, managerId, workSpace);
	}
	
	
	@GetMapping("/findworkspacebytype")
	public ResponseEntity<ResponseStructure<List<WorkSpace>>>  findWorkSpaceByType(@RequestParam String type) {
		return workSpaceService.findByType(type);
	}
	
	@GetMapping("/findworkspacebyspace")
	public ResponseEntity<ResponseStructure<List<WorkSpace>>>  findWorkSpaceBySpace(@RequestParam String squareFeet) {
		return workSpaceService.findBySpace(squareFeet);
	}
	
	@GetMapping("/findworkspacebyprice")
	public ResponseEntity<ResponseStructure<List<WorkSpace>>>  findBfindBypricePerDay(@RequestParam double pricePerDay) {
		return workSpaceService.findBypricePerDay(pricePerDay);
	}
}
