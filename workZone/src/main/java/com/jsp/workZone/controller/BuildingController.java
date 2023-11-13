package com.jsp.workZone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workZone.dto.Building;
import com.jsp.workZone.service.BuildingService;
import com.jsp.workZone.util.ResponseStructure;

@RestController
public class BuildingController {

	@Autowired
	private BuildingService buildingService;

	@PostMapping("/savebuilding")
	public ResponseEntity<ResponseStructure<Building>> saveBuilding(@RequestBody Building building,
			@RequestParam int adminId) {
		return buildingService.saveBuilding(building, adminId);
	}

	@GetMapping("/findbuildingByname")
	public ResponseEntity<ResponseStructure<List<Building>>> findBuildingById(@RequestParam String buildingname) {
		return buildingService.findBuildingByName(buildingname);
	}

	@GetMapping("/findBuildingByCity")
	public ResponseEntity<ResponseStructure<List<Building>>> findBuildingByAddress(@RequestParam String city){
		return buildingService.findBuildingByAddress(city);
	}
	
	/*
	 * Assigning Manager to Building which can be done by Admin only.
	 */

	@PutMapping("/assignmanagertobuilding")
	public ResponseEntity<ResponseStructure<Building>> assignManagerToBuilding(@RequestParam int buildingId,@RequestParam int managerId,@RequestParam int adminId){
		return buildingService.assignManagerToBuilding(buildingId, managerId, adminId);
	}
	
	@GetMapping("/findbuildingbyid")
	public ResponseEntity<ResponseStructure<Building>> findBuildingById(@RequestParam int buildingId) {
		return buildingService.findBuildingById(buildingId);
	}
	
	@PutMapping("/updatebuilding")
	public ResponseEntity<ResponseStructure<Building>> updateBuilding(@RequestBody Building building){
		return buildingService.updateBuilding(building);
	}
	
	@DeleteMapping("/deletebuildingbyid")
	public ResponseEntity<ResponseStructure<Building>> deleteBuildingById(@RequestParam int buildingId){
		return buildingService.deletBuildingById(buildingId);
	}

}
