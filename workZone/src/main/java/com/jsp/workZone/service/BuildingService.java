package com.jsp.workZone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.AdminDao;
import com.jsp.workZone.dao.BuildingDao;
import com.jsp.workZone.dao.ManagerDao;
import com.jsp.workZone.dto.Admin;
import com.jsp.workZone.dto.Building;
import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.exceptionhandlerforworkzone.AdminNotFound;
import com.jsp.workZone.exceptionhandlerforworkzone.BuildingNotfound;
import com.jsp.workZone.exceptionhandlerforworkzone.ManagerNotfound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class BuildingService {

	@Autowired
	private BuildingDao buildingDao;

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private ManagerDao managerDao;

	public ResponseEntity<ResponseStructure<Building>> saveBuilding(Building building, int AdminId) {

		Admin dbAdmin = adminDao.findAdminById(AdminId);

		if (dbAdmin != null) {
			building.setAdmin(dbAdmin);

			Building dbbuilding = buildingDao.saveBuilding(building);

			ResponseStructure<Building> structure = new ResponseStructure<>();
			structure.setData(dbbuilding);
			structure.setMsg("Building Saved Successfully.");
			structure.setStatus(HttpStatus.CREATED.value());

			return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.CREATED);

		}

		throw new AdminNotFound();

	}

	public ResponseEntity<ResponseStructure<List<Building>>> findBuildingByName(String buildingName) {

		List<Building> dbbuilding = buildingDao.fetchBuildingByName(buildingName);
		if (dbbuilding != null) {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setData(dbbuilding);
			structure.setMsg("building found successfully.");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);
		} else {

			throw new BuildingNotfound();
		}
	}

	public ResponseEntity<ResponseStructure<List<Building>>> findBuildingByAddress(String city) {
		List<Building> dbbuBuildings = buildingDao.findBuildingByAddress(city);
		if (dbbuBuildings != null) {
			ResponseStructure<List<Building>> structure = new ResponseStructure<>();
			structure.setData(dbbuBuildings);
			structure.setMsg("building found in the city successfully.");
			structure.setStatus(HttpStatus.FOUND.value());

			return new ResponseEntity<ResponseStructure<List<Building>>>(structure, HttpStatus.FOUND);
		} else {
			throw new BuildingNotfound("Building not found in " + city + " Try with another one!");
		}
	}

	public ResponseEntity<ResponseStructure<Building>> assignManagerToBuilding(int buildingId, int managerId,
			int adminId) {

		Admin admin = adminDao.findAdminById(adminId);

		if (admin != null) {

			Manager manager = managerDao.findManagerById(managerId);

			if (manager != null) {
				System.out.println(manager);
				Building building = buildingDao.findBuildingById(buildingId);

				if (building != null) {
					building.setManager(manager);
					ResponseStructure<Building> structure = new ResponseStructure<>();
					structure.setMsg("manager assigned to the building");
					structure.setStatus(HttpStatus.ACCEPTED.value());
					structure.setData(buildingDao.updateBuilding(building));

					return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.ACCEPTED);
				} else {
					throw new BuildingNotfound("Building is not there to assign manager!");
				}

			} else {
				throw new ManagerNotfound("Manager is not there to assign it to building");
			}

		} else {
			throw new AdminNotFound("Admin not found to assign it to building! ");
		}
	}

	public ResponseEntity<ResponseStructure<Building>> findBuildingById(int id) {

		Building db = buildingDao.findBuildingById(id);

		if (db != null) {

			ResponseStructure<Building> structure = new ResponseStructure<>();
			structure.setMsg("building found successfully..");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(db);

			return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.FOUND);
		} else
			throw new BuildingNotfound("Building does't exist in the database!");

	}

	public ResponseEntity<ResponseStructure<Building>> updateBuilding(Building building) {

		Building db = buildingDao.updateBuilding(building);

		if (db != null) {
			ResponseStructure<Building> structure = new ResponseStructure<>();
			structure.setMsg("Building updated successfully.");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(buildingDao.updateBuilding(building));

			return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.CREATED);
		} else
			throw new BuildingNotfound("Building does't exist in the database! ");
	}

	public ResponseEntity<ResponseStructure<Building>> deletBuildingById(int id) {
		Building db = buildingDao.deleteBuildingById(id);

		if (db != null) {

			ResponseStructure<Building> structure = new ResponseStructure<>();
			structure.setMsg("building successfully deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(buildingDao.deleteBuildingById(id));

			return new ResponseEntity<ResponseStructure<Building>>(structure, HttpStatus.OK);
		} else
			throw new BuildingNotfound("Building is not there to delete.");
	}

}
