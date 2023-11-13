package com.jsp.workZone.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.repo.FloorRepo;

@Repository
public class FloorDao {

	@Autowired
	private FloorRepo floorRepo;

	public List<Floor> listOfFloor() {
		List<Floor> list = floorRepo.findAll();
		return list;
	}

	public Floor findFloorById(int id) {
		if (floorRepo.findById(id).isPresent()) {
			Floor floor = floorRepo.findById(id).get();
			return floor;
		} else
			return null;
	}
	
	public Floor updateFloorById(Floor floor) {
		if(floorRepo.findById(floor.getId()).isPresent()) {
			Floor db = floorRepo.findById(floor.getId()).get();
			
			if(floor.getFloor_Number()==0) {
				floor.setFloor_Number(db.getFloor_Number());
			}
			if(floor.getSpaces()==null) {
				floor.setSpaces(db.getSpaces());
			}
			
			return floorRepo.save(floor);
		}else 
			return null;
	}

}
