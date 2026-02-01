package org.jsp.employee_management_system.service;

import java.util.List;

import org.jsp.employee_management_system.dao.EmployeeDao;
import org.jsp.employee_management_system.entity.Employee;
import org.jsp.employee_management_system.exception.NameValidationException;
import org.jsp.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao empDao;

	@Autowired
	EmployeeRepository empRepo;

	// method to save employee
	public Employee saveEmployeeService(Employee emp) {
		if (emp.getName() == null) {
			throw new NameValidationException("name cannot be null");
		}
		return empDao.saveEmployeeDao(emp);
	}

	// method to fetch employee by id
	public Employee getEmployeeService(int id) {
		return empDao.getEmployeeByIdDao(id);
	}

	// method to search all employee based on salary in asc
	public List<Employee> getAllEmployeeBySalaryAscService() {
		return empRepo.findAllByOrderBySalaryAsc();
	}

	// method to fetch all the record
	public List<Employee> getAllEmployeeService() {
		return empDao.getAllEmployeeDao();
	}

	// method is to delete employee by id
	public String deleteEmployeeByIdService(int id) {
		return empDao.deleteEmployeeByIdDao(id);
	}

	// method to update the record
	public Employee updateEmployeeService(Employee emp) {
		return empDao.updateEmployeeDao(emp);
	}
	
	// method to filter name
	public List<Employee> filterEmployeeBasedOnName(String name){
		return empRepo.findByNameContainingIgnoreCase(name);
	}
}
