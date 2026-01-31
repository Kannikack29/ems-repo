import React, { useState } from "react";
import { Routes, Route } from "react-router-dom";
import EmployeeList from "./components/EmployeeList";
import AddEmployee from "./components/AddEmployee";
import UpdateEmployee from "./components/UpdateEmployee";

function App() {
  const [selectedEmployee, setSelectedEmployee] = useState(null);

  return (
    <div className="container mt-3">
      <Routes>
        <Route
          path="/"
          element={<EmployeeList editEmployee={setSelectedEmployee} />}
        />
        <Route
          path="/add"
          element={<AddEmployee />}
        />
        <Route
          path="/update"
          element={
            <UpdateEmployee
              selectedEmployee={selectedEmployee}
            />
          }
        />
      </Routes>
    </div>
  );
}

export default App;
