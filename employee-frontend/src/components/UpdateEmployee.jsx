import React, { useEffect, useState } from "react";
import { Form, Button, Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { updateEmployee } from "../services/EmployeeService";

const UpdateEmployee = ({ selectedEmployee }) => {
  const navigate = useNavigate();
  const [employee, setEmployee] = useState(null);

  useEffect(() => {
    setEmployee(selectedEmployee);
  }, [selectedEmployee]);

  if (!employee) return <h5>No employee selected</h5>;

  const handleChange = (e) => {
    setEmployee({ ...employee, [e.target.name]: e.target.value });
  };

  const updateEmp = (e) => {
    e.preventDefault();
    updateEmployee(employee).then(() => {
      alert("Employee Updated");
      navigate("/");
    });
  };

  return (
    <Card className="p-3">
      <h4>Update Employee</h4>
      <Form onSubmit={updateEmp}>
        <Form.Control className="mb-2" name="name" value={employee.name} onChange={handleChange} />
        <Form.Control className="mb-2" name="email" value={employee.email} onChange={handleChange} />
        <Form.Control className="mb-2" name="password" value={employee.password} onChange={handleChange} />
        <Form.Control className="mb-2" name="deptName" value={employee.deptName} onChange={handleChange} />
        <Form.Control className="mb-2" name="age" value={employee.age} onChange={handleChange} />
        <Form.Control className="mb-2" name="salary" value={employee.salary} onChange={handleChange} />
        <Button variant="warning" type="submit">Update</Button>
      </Form>
    </Card>
  );
};

export default UpdateEmployee;
