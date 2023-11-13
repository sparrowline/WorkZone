package com.jsp.workZone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.workZone.dto.WorkSpace;

public interface WorkspaceRepo extends JpaRepository<WorkSpace, Integer> {

	public List<WorkSpace> findByType(String type);

	public List<WorkSpace> findBypricePerDay(double pricePerDay);

	public List<WorkSpace> findBysquareFeet(String squareFeet);
}
