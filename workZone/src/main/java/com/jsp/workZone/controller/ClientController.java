package com.jsp.workZone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.workZone.dto.Client;
import com.jsp.workZone.service.ClientService;
import com.jsp.workZone.util.ResponseStructure;

@Controller
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/saveClient")
	public ResponseEntity<ResponseStructure<Client>> saveClient(@RequestBody Client client) {
		return clientService.saveClient(client);
	}

}
