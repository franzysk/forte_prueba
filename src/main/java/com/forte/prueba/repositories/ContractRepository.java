package com.forte.prueba.repositories;

import com.forte.prueba.models.Contract;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContractRepository extends PagingAndSortingRepository<Contract, Long> {
    @Query("SELECT c FROM Contract c WHERE c.employeeId = :employeeId AND c.isActive = :isActive")
    Contract findByEmployeeId(@Param("employeeId") int employeeId, @Param("isActive") boolean isActive);
}
