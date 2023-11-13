package com.jsp.workZone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workZone.dao.ClientDao;
import com.jsp.workZone.dto.Client;
import com.jsp.workZone.util.ResponseStructure;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	public ResponseEntity<ResponseStructure<Client>> saveClient(Client client) {

		Client dbClient = clientDao.saveClient(client);
		ResponseStructure<Client> structure = new ResponseStructure<Client>();
		structure.setData(dbClient);
		structure.setMsg("Client Data Saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<Client>>(structure, HttpStatus.CREATED);

	}

}
