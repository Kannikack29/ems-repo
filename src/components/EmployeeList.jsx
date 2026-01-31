import React, { useEffect, useState } from "react";
import { Table, Button, Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import {
  getAllEmployees,
  deleteEmployee,
  getEmployeesBySalaryAsc
} from "../services/EmployeeService";

const EmployeeList = ({ editEmployee }) => {
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate();

  const loadEmployees = () => {
    getAllEmployees().then(res => {
      setEmployees(res.data.data);
    });
  };

  useEffect(() => {
    loadEmployees();
  }, []);

  const removeEmployee = (id) => {
    deleteEmployee(id).then(() => {
      alert("Employee Deleted");
      loadEmployees();
    });
  };

  const editEmp = (emp) => {
    editEmployee(emp);
    navigate("/update");
  };

  return (
    <Card className="p-3 d-flex justify-content-center align-items-center">
      <h3>Employee List</h3>

      <Button className="mb-2" onClick={() => navigate("/add")}>
        Add Employee
      </Button>

      <Table striped bordered hover className="text-center">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Dept</th>
            <th>Age</th>
            <th>Salary</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(emp => (
            <tr key={emp.empid}>
              <td>{emp.empid}</td>
              <td>{emp.name}</td>
              <td>{emp.email}</td>
              <td>{emp.deptName}</td>
              <td>{emp.age}</td>
              <td>{emp.salary}</td>
              <td className="d-flex gap-3 px-0 justify-content-center align-items-center">
                <Button
                  variant="warning"
                  size="sm"
                  onClick={() => editEmp(emp)}
                >
                  Edit
                </Button>
                <Button
                  variant="danger"
                  size="sm"
                  onClick={() => removeEmployee(emp.empid)}
                >
                  Delete
                </Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </Card> 
  );
};

export default EmployeeList;
