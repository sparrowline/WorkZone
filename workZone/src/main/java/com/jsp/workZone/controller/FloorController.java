package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.service.FloorService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class FloorController {
	
	@Autowired
	private FloorService floorService;
	
	
	@GetMapping("/floor")
	public ResponseEntity<ResponseStructure<Floor>> findFloorById(@RequestParam int floorId) {
		return floorService.findFloorById(floorId);
	}
	
	

}
