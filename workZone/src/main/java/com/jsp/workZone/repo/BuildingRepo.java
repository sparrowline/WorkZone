package com.jsp.workZone.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.workZone.dto.Building;

public interface BuildingRepo extends JpaRepository<Building, Integer> {

	@Query("Select a from Building a where a.building_Name =?1")
	public List<Building> fetchbuildingByName(String BuildingName);

	@Query("SELECT b FROM Building b WHERE b.address.city = ?1")
	public List<Building> findBuildingByAddress(String city);

}
