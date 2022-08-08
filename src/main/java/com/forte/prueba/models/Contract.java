package com.forte.prueba.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Contract")
@Getter
@Setter
public class Contract extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ContractId",
            nullable = false,
            unique = true)
    private long contractId;

    @Column(name = "EmployeeId",
            nullable = false)
    private int employeeId;

    @Column(name = "ContractTypeId",
            nullable = false)
    private int contractTypeId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "DateFrom",
            nullable = false)
    private Date dateFrom;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "DateTo",
            nullable = false)
    private Date dateTo;

    @Column(name = "SalaryPerDay",
            nullable = false)
    private BigDecimal salaryPerDay;
}
