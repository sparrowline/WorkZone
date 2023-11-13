package com.jsp.workZone.exceptionhandlerforworkzone;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.workZone.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandlerForWorkZone {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlExceptionHandler(SQLIntegrityConstraintViolationException ex) {

		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(ex.getMessage());
		structure.setMsg("you cannot perform this operation");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AdminNotFound.class)
	public ResponseEntity<ResponseStructure<String>> adminNotFound(AdminNotFound adminNotFound) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(adminNotFound.getMsg());
		structure.setMsg("admin does not exist in the database.");
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BuildingNotfound.class)
	public ResponseEntity<ResponseStructure<String>> buildingNotFound(BuildingNotfound buildingNotfound) {

		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(buildingNotfound.getMsg());
		structure.setMsg("Building not found!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ManagerNotfound.class)
	public ResponseEntity<ResponseStructure<String>> managerNotfound(ManagerNotfound managerNotfound){
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(managerNotfound.getMsg());
		structure.setMsg("Manager not found!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ImageNotFound.class)
	public ResponseEntity<ResponseStructure<String>> imageNotFound(ImageNotFound imageNotFound){
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(imageNotFound.getMsg());
		structure.setMsg("Image not saved!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoAddressFound.class)
	public ResponseEntity<ResponseStructure<String>> noAddressFound(NoAddressFound noAddressFound){
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(noAddressFound.getMsg());
		structure.setMsg("Address not there in database!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoFloorsFound.class)
	public ResponseEntity<ResponseStructure<String>> noFloorsFound(NoFloorsFound noFloorsFound){
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(noFloorsFound.getMsg());
		structure.setMsg("floor is not there in database!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TypeNotFound.class)
	public ResponseEntity<ResponseStructure<String>> typeNotFound(TypeNotFound typeNotFound){
		
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(typeNotFound.getMsg());
		structure.setMsg("type not exist!");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
