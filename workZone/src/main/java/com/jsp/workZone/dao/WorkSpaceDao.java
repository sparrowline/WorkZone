package com.jsp.workZone.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workZone.dto.WorkSpace;
import com.jsp.workZone.repo.WorkspaceRepo;

@Repository
public class WorkSpaceDao {

	@Autowired
	private WorkspaceRepo workspaceRepo;

	@Autowired
	private ManagerDao managerDao;

	public WorkSpace saveWorkSpace(WorkSpace work) {
		if (work != null) {
			return workspaceRepo.save(work);

		} else
			return null;

	}
	
	public List<WorkSpace> findByType(String type) {
		if(type!=null) {
			return workspaceRepo.findByType(type);
		}else
			return null;
	}
	
	
	public List<WorkSpace> findBySpaces(String squareFeet) {
		if(squareFeet!=null) {
			return workspaceRepo.findByType(squareFeet);
		}else
			return null;
	}
	
	public List<WorkSpace> findBfindBypricePerDay(double pricePerDay) {
		if(pricePerDay!=0) {
			return workspaceRepo.findBypricePerDay(pricePerDay);
		}else
			return null;
	}


}
