package com.jsp.workZone.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.workZone.dto.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{

}
