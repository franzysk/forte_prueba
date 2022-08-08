package com.forte.prueba.services;

import com.forte.prueba.models.Employee;
import com.forte.prueba.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(boolean isActive) {
        return employeeRepository.findEmployees(isActive);
    }

    public Employee getEmployee(int employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public Employee getEmployee(String taxIdNumber) {
        return employeeRepository.findByTaxIdNumber(taxIdNumber).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}
