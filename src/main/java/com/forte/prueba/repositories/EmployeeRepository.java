package com.forte.prueba.repositories;

import com.forte.prueba.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.isActive = :isActive")
    List<Employee> findEmployees(@Param("isActive") boolean isActive);

    @Query("SELECT e FROM Employee e WHERE e.taxIdNumber = :taxIdNumber AND e.isActive = true")
    Optional<Employee> findByTaxIdNumber(@Param("taxIdNumber") String taxIdNumber);
}
