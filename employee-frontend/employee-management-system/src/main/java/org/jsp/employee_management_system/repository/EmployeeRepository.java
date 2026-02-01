package org.jsp.employee_management_system.repository;

import java.util.List;

import org.jsp.employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	List<Employee> findAllByOrderBySalaryAsc();

	List<Employee> findByNameContainingIgnoreCase(String name);
}
