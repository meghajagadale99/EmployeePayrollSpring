package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeData;
import com.bridgelabz.employeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public List<EmployeeData> employees() {
        return employeeService.employees();
    }

    @GetMapping(value = "/get-employee-by-id")
    public EmployeeData getEmployeeById(@RequestParam int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "/get-employee-by-Name")
    public EmployeeData getStudentByName(@RequestParam String name) {
        return employeeService.getEmployeeByName(name);
    }

    @GetMapping(value = "/get-employee-by-salary")
    public EmployeeData getEmployeeBySalary(@RequestParam long salary) {
        return employeeService.getEmployeeBySalary(salary);
    }

    @PostMapping(value = "/employee")
    public EmployeeData addStudent(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @PutMapping(value = "/employee/{id}")
    public EmployeeData updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping(value = "/employee")
    public String deleteEmployee(@RequestParam int id) {
        return employeeService.deleteEmployee(id);
    }

}
