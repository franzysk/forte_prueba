package com.forte.prueba.services;

import com.forte.prueba.repositories.ContractTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractTypeService {
    @Autowired
    private ContractTypeRepository contractTypeRepository;

    public String getContractTypeName(int id) {
        return contractTypeRepository.findContractTypeName(id, true);
    }
}
