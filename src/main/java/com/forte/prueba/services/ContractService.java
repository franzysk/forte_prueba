package com.forte.prueba.services;

import com.forte.prueba.models.Contract;
import com.forte.prueba.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public Contract getContract(int employeeId, boolean isActive) {
        return contractRepository.findByEmployeeId(employeeId, isActive);
    }

    public Contract updateContract(Contract contract) {
        return contractRepository.save(contract);
    }


}
