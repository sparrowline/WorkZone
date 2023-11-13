package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.FloorDao;
import com.jsp.workZone.dto.Floor;
import com.jsp.workZone.exceptionhandlerforworkzone.NoFloorsFound;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class FloorService {

	@Autowired
	private FloorDao floorDao;

	public ResponseEntity<ResponseStructure<Floor>> findFloorById(int id) {

		Floor db = floorDao.findFloorById(id);
		if (db != null) {
			ResponseStructure<Floor> structure = new ResponseStructure<>();
			structure.setMsg("floor found successfully!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(floorDao.findFloorById(id));

			return new ResponseEntity<ResponseStructure<Floor>>(structure, HttpStatus.FOUND);
		}else
			throw new NoFloorsFound("floors are not there with your id!");
		
	}

}
