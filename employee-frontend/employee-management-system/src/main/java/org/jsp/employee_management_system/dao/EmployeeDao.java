package org.jsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.employee_management_system.entity.Employee;
import org.jsp.employee_management_system.exception.IdNotFoundException;
import org.jsp.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepository empRepo;

	// this method is responsible save record
	public Employee saveEmployeeDao(Employee emp) {
		return empRepo.save(emp);
	}

	// this method is responsible to fetch record based on id
	public Employee getEmployeeByIdDao(int id) {
		Optional<Employee> emp = empRepo.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			return null;
		}
	}

	// this method is responsible to fetch all the record
	public List<Employee> getAllEmployeeDao() {
		return empRepo.findAll();
	}

//	this method is responsible to delete employee by id
	public String deleteEmployeeByIdDao(int id) {
		Optional<Employee> emp = empRepo.findById(id);
		if (emp.isPresent()) {
			Employee e = emp.get();
			empRepo.delete(e);
			return "employee data deleted";
		} else {
			throw new IdNotFoundException("given id not present");
		}
	}

	// this method is responsible to update the record
	public Employee updateEmployeeDao(Employee emp) {
		return empRepo.save(emp);
	}
}
