import React, { useState } from "react";
import { Form, Button, Card } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { addEmployee } from "../services/EmployeeService";

const AddEmployee = () => {
  const navigate = useNavigate();

  const [employee, setEmployee] = useState({
    name: "",
    email: "",
    password: "",
    deptName: "",
    age: "",
    salary: ""
  });

  const handleChange = (e) => {
    setEmployee({ ...employee, [e.target.name]: e.target.value });
  };

  const saveEmployee = (e) => {
    e.preventDefault();
    addEmployee(employee).then(() => {
      alert("Employee Added Successfully");
      navigate("/");
    });
  };

  return (
    <Card className="p-3">
      <h4>Add Employee</h4>
      <Form onSubmit={saveEmployee}>
        <Form.Control className="mb-2" name="name" placeholder="Name" onChange={handleChange} />
        <Form.Control className="mb-2" name="email" placeholder="Email" onChange={handleChange} />
        <Form.Control className="mb-2" name="password" placeholder="password" onChange={handleChange} />
        <Form.Control className="mb-2" name="deptName" placeholder="Department" onChange={handleChange} />
        <Form.Control className="mb-2" name="age" placeholder="Age" onChange={handleChange} />
        <Form.Control className="mb-2" name="salary" placeholder="Salary" onChange={handleChange} />
        <Button type="submit">Save</Button>
      </Form>
    </Card>
  );
};

export default AddEmployee;
