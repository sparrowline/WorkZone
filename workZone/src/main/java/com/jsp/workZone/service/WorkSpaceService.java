package com.jsp.workZone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.FloorDao;
import com.jsp.workZone.dao.ManagerDao;
import com.jsp.workZone.dao.WorkSpaceDao;
import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.enums.WorkSpaceType;
import com.jsp.workZone.exceptionhandlerforworkzone.ManagerNotfound;
import com.jsp.workZone.exceptionhandlerforworkzone.NoFloorsFound;
import com.jsp.workZone.exceptionhandlerforworkzone.TypeNotFound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class WorkSpaceService {

	@Autowired
	private WorkSpaceDao workSpaceDao;

	@Autowired
	private FloorDao floorDao;

	@Autowired
	private ManagerDao managerDao;

	public ResponseEntity<ResponseStructure<WorkSpace>> saveWorkSpace(int floorId, int managerId, WorkSpace workSpace) {

		Manager mdb = managerDao.findManagerById(managerId);
		if (mdb != null) {
			Floor floor = floorDao.findFloorById(floorId);
			if (floor != null) {

				if (workSpace.getType().equals("CAFETERIA")) {
					workSpace.setType(WorkSpaceType.CAFETERIA.name());
				}
				if (workSpace.getType().equals("PRIVATE OFFICE")) {
					workSpace.setType(WorkSpaceType.PRIVATE_OFFICE.name());
				}
				if (workSpace.getType().equals("SHARED OFFICE")) {
					workSpace.setType(WorkSpaceType.SHARED_OFFICE.name());
				}
				if (workSpace.getType().equals("CO WORKING SPACE")) {
					workSpace.setType(WorkSpaceType.CO_WORKING_SPACE.name());
				}
				if (workSpace.getType().equals("VIRTUAL OFFICE")) {
					workSpace.setType(WorkSpaceType.VIRTUAL_OFFICE.name());
				}
				if (workSpace.getType().equals("MEETING ROOM")) {
					workSpace.setType(WorkSpaceType.MEETING_ROOM.name());
				}
				if (workSpace.getType().equals("EVENT_SPACE")) {
					workSpace.setType(WorkSpaceType.EVENT_SPACE.name());
				}
				if (workSpace.getType().equals("CUSTOM")) {
					workSpace.setType(WorkSpaceType.CUSTOM.name());
				}
				if (workSpace.getType().equals("FUNZONE")) {
					workSpace.setType(WorkSpaceType.FUNZONE.name());
				}
				if (workSpace.getType().equals("CONFERENCE ROOM")) {
					workSpace.setType(WorkSpaceType.CONFERENCE_ROOM.name());
				}
				if (workSpace.getType().equals("REMOTE WORKING")) {
					workSpace.setType(WorkSpaceType.REMOTE_WORKING.name());
				}
				if (workSpace.getType().equals("FOOCUS ROOM")) {
					workSpace.setType(WorkSpaceType.FOOCUS_ROOM.name());
				}

				List<WorkSpace> list = new ArrayList<>();
				list.add(workSpace);
				list.addAll(floor.getSpaces());

				floor.setSpaces(list);
				floorDao.updateFloorById(floor);

				ResponseStructure<WorkSpace> structure = new ResponseStructure<>();
				structure.setData(workSpaceDao.saveWorkSpace(workSpace));
				structure.setMsg("Workspace updated succesfully");
				structure.setStatus(HttpStatus.CREATED.value());

				return new ResponseEntity<ResponseStructure<WorkSpace>>(structure, HttpStatus.CREATED);
			} else

				throw new NoFloorsFound("floor does not exist.");
		} else
			throw new ManagerNotfound("manager does not exist.");

	}

	public ResponseEntity<ResponseStructure<List<WorkSpace>>> findByType(String type) {

		List<WorkSpace> db = workSpaceDao.findByType(type);

		if (!db.isEmpty()) {

			ResponseStructure<List<WorkSpace>> structure = new ResponseStructure<>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMsg("Type found");
			structure.setData(db);

			return new ResponseEntity<ResponseStructure<List<WorkSpace>>>(structure, HttpStatus.FOUND);

		} else
			throw new TypeNotFound("type not found");
	}

	public ResponseEntity<ResponseStructure<List<WorkSpace>>> findBySpace(String space) {

		List<WorkSpace> db = workSpaceDao.findBySpaces(space);

		if (!db.isEmpty()) {

			ResponseStructure<List<WorkSpace>> structure = new ResponseStructure<>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMsg("space availble!");
			structure.setData(db);

			return new ResponseEntity<ResponseStructure<List<WorkSpace>>>(structure, HttpStatus.FOUND);

		} else
			throw new TypeNotFound("space not availble");
	}
	
	public ResponseEntity<ResponseStructure<List<WorkSpace>>> findBypricePerDay(double pricePerDay) {

		List<WorkSpace> db = workSpaceDao.findBfindBypricePerDay(pricePerDay);

		if (!db.isEmpty()) {

			ResponseStructure<List<WorkSpace>> structure = new ResponseStructure<>();
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMsg("available!");
			structure.setData(db);

			return new ResponseEntity<ResponseStructure<List<WorkSpace>>>(structure, HttpStatus.FOUND);

		} else
			throw new TypeNotFound("price not matched");
	}
}
