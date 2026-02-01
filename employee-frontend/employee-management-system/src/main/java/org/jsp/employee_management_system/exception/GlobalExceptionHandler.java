package org.jsp.employee_management_system.exception;

import org.jsp.employee_management_system.entity.Employee;
import org.jsp.employee_management_system.response_structure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NameValidationException.class)
	public ResponseEntity<ResponseStructure<Employee>> nameValidationExceptionHandler(NameValidationException n){
		ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
		rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("message: "+n.getMessage());
		rs.setData(null);
		
		return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<Employee>> idNotFoundException(IdNotFoundException i){
		ResponseStructure<Employee> rs = new ResponseStructure<Employee>();
		rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		rs.setMessage(i.getMessage());
		rs.setData(null);
		
		return new ResponseEntity<ResponseStructure<Employee>>(rs,HttpStatus.BAD_REQUEST);
	}
	
}
