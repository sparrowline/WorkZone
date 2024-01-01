//package com.jsp.workZone.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.jsp.workZone.dao.ClientBookingDao;
//import com.jsp.workZone.dao.ClientDao;
//import com.jsp.workZone.dao.WorkSpaceDao;
//import com.jsp.workZone.dto.Client;
//import com.jsp.workZone.dto.ClientBooking;
//import com.jsp.workZone.dto.WorkSpace;
//import com.jsp.workZone.util.ResponseStructure;
//
//@Service
//public class ClientBookingService {
//	
//	@Autowired
//	private ClientBookingDao bookingDao;
//
//	@Autowired
//	private ClientDao clientDao;
//	
//	@Autowired
//	private WorkSpaceDao spaceDao;
//	
//	public ResponseEntity<ResponseStructure<ClientBooking>> saveClientBooking(int c_id,int w_id, ClientBooking clientBooking) {
//		
//		 Client client = clientDao.getClientById(c_id);
//		
//		if(clientDao.getClientById(c_id)!=null) {
//			
//			//WorkSpace space = spaceDao.find
//		}
//		
//		 
//	}
//}
