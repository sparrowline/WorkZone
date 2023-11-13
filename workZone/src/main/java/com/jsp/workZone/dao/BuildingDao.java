package com.jsp.workZone.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Building;
import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.repo.BuildingRepo;

@Repository
public class BuildingDao {

	@Autowired
	private BuildingRepo buildingRepo;

	@Autowired
	private FloorDao floorDao;

	public Building saveBuilding(Building building) {
		return buildingRepo.save(building);
	}

	public Building updateBuilding(Building building) {
		
		if ( buildingRepo.findById(building.getId()).isPresent()) {
			
			Building db = buildingRepo.findById(building.getId()).get();

			if (building.getBuilding_Name() == null) {
				building.setBuilding_Name(db.getBuilding_Name());
			}
			if (building.getAddress() == null) {
				building.setAddress(db.getAddress());
			}
			if (building.getFloors() == null) {
				building.setFloors(db.getFloors());
			}
			if (building.getManager() == null) {
				building.setManager(db.getManager());
			}
			if (building.getAdmin() == null) {
				building.setAdmin(db.getAdmin());
			}
			if (building.getRatings() == 0) {
				building.setRatings(db.getRatings());
			}
			return buildingRepo.save(building);
		} else
			return null;

	}

	public List<Building> fetchBuildingByName(String buildingName) {

		List<Building> db = buildingRepo.fetchbuildingByName(buildingName);

		if (db.isEmpty()) {
			return null;
		} else {
			return db;
		}
	}

	public List<Building> findBuildingByAddress(String city) {

		List<Building> db = buildingRepo.findBuildingByAddress(city);

		if (db.isEmpty()) {
			return null;
		} else {
			return db;
		}
	}

	public Building findBuildingById(int id) {

		if (buildingRepo.findById(id).isPresent()) {
			Building db = buildingRepo.findById(id).get();

			return db;
		} else {
			return null;
		}
	}

	public Building deleteBuildingById(int id) {

		if (buildingRepo.findById(id).isPresent()) {
			Building db = buildingRepo.findById(id).get();

			List<Floor> dblist = floorDao.listOfFloor();

			if (dblist != null) {
				dblist.removeAll(dblist);

			}
			buildingRepo.deleteById(id);
			return db;

		}

		return null;
	}

}
