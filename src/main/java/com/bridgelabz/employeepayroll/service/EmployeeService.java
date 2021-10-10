package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.EmployeeData;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private  EmployeeRepository employeeRepository;

    public  List<EmployeeData> employees() {
        return employeeRepository.findAll();
    }

    public EmployeeData getEmployeeById(int id) {
        Optional<EmployeeData> employeeData = employeeRepository.findById(id);
        if (employeeData.isPresent()) {
            return employeeData.get();
        }
        return null;
    }

    public EmployeeData getEmployeeByName(String name) {
        Optional<EmployeeData> employeeData = employeeRepository.findByName(name);
        if (employeeData.isPresent()) {
            return employeeData.get();
        }
        return null;
    }

    public EmployeeData getEmployeeBySalary(long salary) {
        Optional<EmployeeData> employeeData = employeeRepository.findBySalary(salary);
        if (employeeData.isPresent()) {
            return employeeData.get();
        }
        return null;
    }

    public EmployeeData addEmployee(EmployeeDTO employeeDTO) {
        EmployeeData employeeData = new EmployeeData();
        employeeData.setName(employeeDTO.getName());
        employeeData.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(employeeData);
    }

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

    public String deleteEmployee(int id) {
        Optional<EmployeeData> employeeData = employeeRepository.findById(id);
        if (employeeData.isPresent()) {
            employeeRepository.delete(employeeData.get());
            return "Employee Record is deleted successfully.";
        }
        return "Record does not exists with this id : " + id;
    }


}
