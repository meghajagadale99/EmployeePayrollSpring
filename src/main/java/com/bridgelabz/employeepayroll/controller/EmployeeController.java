/******************************************************************************
 *  Purpose: Class is implemented for handling the request from the user
 *  		 @RestController defines that it will deal with the rest controller
 *
 *  @author  Megha Jagadale
 *  @version 1.0
 *  @since   10-10-2021
 *
 ******************************************************************************/
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

    /**
     * Function to receive get request from clint
     *
     * @return list of all employees' payroll data
     */
    @GetMapping(value = "/employees")
    public List<EmployeeData> employees() {
        return employeeService.employees();
    }
    /**
     * Function to receive get request from clint
     *
     * @param  id unique Id of employee
     * @return  employee payroll data from DB
     */
    @GetMapping(value = "/get-employee-by-id")
    public EmployeeData getEmployeeById(@RequestParam int id) {
        return employeeService.getEmployeeById(id);
    }
    /**
     * Function to receive get request from clint
     *
     * @param  name unique name of employee
     * @return  employee payroll data from DB
     */
    @GetMapping(value = "/get-employee-by-Name")
    public EmployeeData getStudentByName(@RequestParam String name) {
        return employeeService.getEmployeeByName(name);
    }
    /**
     * Function to receive get request from clint
     *
     * @param salary unique salary of employee
     * @return employee payroll data from DB
     */
    @GetMapping(value = "/get-employee-by-salary")
    public EmployeeData getEmployeeBySalary(@RequestParam long salary) {
        return employeeService.getEmployeeBySalary(salary);
    }
    /**
     * Function to receive post request from clint
     *
     * @param  employeeDTO payroll data from clint
     * @return  newly created employee payroll data
     */
    @PostMapping(value = "/employee")
    public EmployeeData addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }
    /**
     * Function to receive put request from clint
     *
     * @param id  unique Id of employee
     * @param employeeDTO employee payroll data from clint
     * @return  updated employee payroll data
     */
    @PutMapping(value = "/employee/{id}")
    public EmployeeData updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }
    /**
     * Function to receive delete request from clint
     *
     * @param id unique Id of employee
     * @return  updated employee payroll data
     */
    @DeleteMapping(value = "/employee")
    public String deleteEmployee(@RequestParam int id) {
        return employeeService.deleteEmployee(id);
    }

}
