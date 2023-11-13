package com.jsp.workZone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.Manager;
import com.jsp.workZone.repo.ManagerRepo;

@Repository
public class ManagerDao {
	
	@Autowired
	private ManagerRepo managerRepo;
	
	
	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}
	
	public Manager findManagerById(int id) {
		if(managerRepo.findById(id).isPresent()) {
			Manager manager = managerRepo.findById(id).get();
			return manager;

		}else {
			return null;
		}

	}

}
