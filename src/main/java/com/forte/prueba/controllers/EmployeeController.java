package com.forte.prueba.controllers;

import com.forte.prueba.dto.ContractDto;
import com.forte.prueba.dto.EmployeeContractDto;
import com.forte.prueba.dto.EmployeeDto;
import com.forte.prueba.models.Contract;
import com.forte.prueba.models.Employee;
import com.forte.prueba.services.ContractService;
import com.forte.prueba.services.ContractTypeService;
import com.forte.prueba.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractTypeService contractTypeService;

    @GetMapping("/active")
    public ResponseEntity<List<EmployeeContractDto>> getActiveEmployees() {
        List<Employee> employees = employeeService.getEmployees(true);
        List<EmployeeContractDto> employeeContractList = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeContractDto employeeContractDto = new EmployeeContractDto();
            employeeContractDto.setName(employee.getName() + " " + employee.getLastName());
            employeeContractDto.setTaxIdNumber(employee.getTaxIdNumber());

            Contract contract = contractService.getContract(employee.getEmployeeId(), true);
            if (contract != null) {
                employeeContractDto.setContractDateFrom(contract.getDateFrom());
                employeeContractDto.setContractDateTo(contract.getDateTo());
                employeeContractDto.setContractSalaryPerDay(contract.getSalaryPerDay());
                employeeContractDto.setContractTypeName(contractTypeService.getContractTypeName(
                        contract.getContractTypeId()));
            }

            employeeContractList.add(employeeContractDto);
        }
        return new ResponseEntity<>(employeeContractList, HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<String> putEmployee(@Validated @RequestBody EmployeeDto newEmployee) {
        if (employeeService.getEmployee(newEmployee.getTaxIdNumber()) != null)
            return new ResponseEntity<>("Employee already exists",HttpStatus.CONFLICT);

        Employee employee = new Employee();
        employee.setName(newEmployee.getName());
        employee.setLastName(newEmployee.getLastName());
        employee.setBirthDate(newEmployee.getBirthDate());
        employee.setTaxIdNumber(newEmployee.getTaxIdNumber());
        employee.setEmail(newEmployee.getEmail());
        employee.setCellPhone(newEmployee.getCellPhone());
        employee.setActive(true);
        employee.setDateCreated(new Date());

        employeeService.saveEmployee(employee);
        return new ResponseEntity<>("Employee created", HttpStatus.OK);
    }

    @PatchMapping("/")
    public ResponseEntity<String> patchEmployee(@Validated @RequestBody EmployeeDto newEmployee) {
        Employee employee = employeeService.getEmployee(newEmployee.getTaxIdNumber());
        if (employee == null)
            return new ResponseEntity<>("Employee not found",HttpStatus.NOT_FOUND);

        employee.setName(newEmployee.getName());
        employee.setLastName(newEmployee.getLastName());
        employee.setBirthDate(newEmployee.getBirthDate());
        employee.setTaxIdNumber(newEmployee.getTaxIdNumber());
        employee.setEmail(newEmployee.getEmail());
        employee.setCellPhone(newEmployee.getCellPhone());
        employee.setActive(true);
        employee.setDateCreated(new Date());

        employeeService.saveEmployee(employee);
        return new ResponseEntity<>("Employee updated", HttpStatus.OK);
    }

    @PostMapping("/{employeeId}/contract")
    public ResponseEntity<String> createContract(@Validated @PathVariable int employeeId,
                                                 @Validated @RequestBody ContractDto contractData) {

        if (employeeService.getEmployee(employeeId) == null)
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);

        Contract currentContract = contractService.getContract(employeeId, true);
        if (currentContract != null) {
            currentContract.setDateTo(new Date());
            currentContract.setActive(false);
            contractService.updateContract(currentContract);
        }

        Contract newContract = new Contract();
        newContract.setEmployeeId(employeeId);
        newContract.setContractTypeId(contractData.getContractTypeId());
        newContract.setDateFrom(contractData.getDateFrom());
        newContract.setDateTo(contractData.getDateTo());
        newContract.setSalaryPerDay(contractData.getSalaryPerDay());
        newContract.setActive(true);
        newContract.setDateCreated(new Date());

        contractService.updateContract(newContract);

        return new ResponseEntity<>("Contract created for employee Id " + employeeId, HttpStatus.CREATED);
    }
}
