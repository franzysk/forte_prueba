package com.forte.prueba.repositories;

import com.forte.prueba.models.ContractType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContractTypeRepository extends PagingAndSortingRepository<ContractType, Integer> {
    @Query("SELECT e.name FROM ContractType e WHERE e.contractTypeId = :id AND e.isActive = :isActive")
    String findContractTypeName(@Param("id") int id, @Param("isActive") boolean isActive);
}
