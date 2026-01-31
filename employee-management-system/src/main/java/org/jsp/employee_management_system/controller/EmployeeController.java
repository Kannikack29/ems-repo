package org.jsp.employee_management_system.controller;

import java.util.List;

import org.jsp.employee_management_system.entity.Employee;
import org.jsp.employee_management_system.exception.IdNotFoundException;
import org.jsp.employee_management_system.response_structure.ResponseStructure;
import org.jsp.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService empServ;

    @PostMapping("/employees")
    @Operation(summary = "this is post method for employee",description = "this is post method for employee to save employee data")
    @ApiResponses({
    	@ApiResponse(responseCode = "201",description = "data is stored successfully"),
    	@ApiResponse(responseCode = "404",description = "data not stored")
    })
    public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee emp) {
        Employee e = empServ.saveEmployeeService(emp);
        ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("Employee created successfully...");
        rs.setData(e);
        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ResponseStructure<Employee>> getEmployee(@PathVariable int id) {
        Employee emp = empServ.getEmployeeService(id);
        if (emp != null) {
            ResponseStructure<Employee> rs = new ResponseStructure<>();
            rs.setStatusCode(HttpStatus.OK.value());
            rs.setMessage("Successfully fetched data");
            rs.setData(emp);
            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            throw new IdNotFoundException("Given ID not present");
        }
    }

    @GetMapping("/employees/search")
    public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployeeBySalaryAsc() {
        List<Employee> list = empServ.getAllEmployeeBySalaryAscService();
        ResponseStructure<List<Employee>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Fetched employees by salary ascending");
        rs.setData(list);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmployees() {
        List<Employee> list = empServ.getAllEmployeeService();
        ResponseStructure<List<Employee>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Fetched all employees");
        rs.setData(list);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteEmployee(@PathVariable int id) {
        String result = empServ.deleteEmployeeByIdService(id);
        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employee deleted successfully");
        rs.setData(result);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee emp) {
        Employee updatedEmp = empServ.updateEmployeeService(emp);
        ResponseStructure<Employee> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Employee updated successfully");
        rs.setData(updatedEmp);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
    
    @GetMapping("/employees/filter")
    public ResponseEntity<ResponseStructure<List<Employee>>> filterEmployeeNameController(@PathVariable String name) {
        List<Employee> list = empServ.filterEmployeeBasedOnName(name);
        ResponseStructure<List<Employee>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("filtered employees by named");
        rs.setData(list);
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
