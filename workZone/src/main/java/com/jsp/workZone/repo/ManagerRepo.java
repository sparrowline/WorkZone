package com.jsp.workZone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.workZone.dto.Manager;

public interface ManagerRepo extends JpaRepository<Manager, Integer> {

}
