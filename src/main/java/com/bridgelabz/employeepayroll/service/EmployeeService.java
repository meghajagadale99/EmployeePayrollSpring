/******************************************************************************
 *  Purpose: Class is implemented for handling the service the controller
 *         @Service annotation defines this class is service class
 *
 *  @author Megha Jagadale
 *  @version 1.0
 *  @since 10-10-2021
 *
 ******************************************************************************/

package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeData;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Function to get the list of all employee stored in DB
     *
     * @return list of employee payroll data
     */
    public List<EmployeeData> employees() {
        return employeeRepository.findAll();
    }

    /**
     * Function to get a particular employee data object stored in DB
     *
     * @param id unique Id of employee
     * @return employee payroll data object
     */
    public EmployeeData getEmployeeById(int id) {
        Optional<EmployeeData> employeeData = employeeRepository.findById(id);
        if (employeeData.isPresent()) {
            return employeeData.get();
        }
        return null;
    }

    /**
     * Function to get a particular employee data object stored in DB
     *
     * @param name unique name of employee
     * @return employee payroll data object
     */
    public EmployeeData getEmployeeByName(String name) {
        Optional<EmployeeData> employeeData = employeeRepository.findByName(name);
        if (employeeData.isPresent()) {
            return employeeData.get();
        }
        return null;
    }

    /**
     * Function to get a particular employee data object stored in DB
     *
     * @param salary unique salary of employee
     * @return employee payroll data object
     */
    public EmployeeData getEmployeeBySalary(long salary) {
        Optional<EmployeeData> employeeData = employeeRepository.findBySalary(salary);
        if (employeeData.isPresent()) {
            return employeeData.get();
        }
        return null;
    }

    /**
     * Function to create employee payroll data object.
     * This function maps employee dto object into employee entity object and then store it into DB
     *
     * @param employeeDTO employee payroll data from clint
     * @return employee payroll data created by this layer
     */
    public EmployeeData addEmployee(EmployeeDTO employeeDTO) {
        EmployeeData employeeData = modelMapper.map(employeeDTO, EmployeeData.class);
        return employeeRepository.save(employeeData);
    }

    /**
     * Function to update stored employee payroll data object.
     * This function maps updated field of employee dto object into employee
     * entity object and then store updated object into DB
     *
     * @param id          unique Id of employee
     * @param employeeDTO employee payroll data from clint
     * @return employee payroll data updated by this layer
     */
    public EmployeeData updateEmployee(int id, EmployeeDTO employeeDTO) {
        Optional<EmployeeData> optionalEmployeeData = employeeRepository.findById(id);
        if (optionalEmployeeData.isPresent()) {
            EmployeeData employeeData = optionalEmployeeData.get();
            employeeData.setName(employeeDTO.getName());
            employeeData.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employeeData);
        }
        return null;
    }

    /**
     * Function to get particular entity object from DB and delete.
     *
     * @param id unique Id of employee
     * @return String message containing status of operation
     */
    public String deleteEmployee(int id) {
        Optional<EmployeeData> employeeData = employeeRepository.findById(id);
        if (employeeData.isPresent()) {
            employeeRepository.delete(employeeData.get());
            return "Employee Record is deleted successfully.";
        }
        return "Record does not exists with this id : " + id;
    }


}
