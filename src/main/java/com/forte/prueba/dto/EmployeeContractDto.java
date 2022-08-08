package com.forte.prueba.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmployeeContractDto {

    private String name;

    private String taxIdNumber;

    private String contractTypeName;

    private Date contractDateFrom;

    private Date contractDateTo;

    private BigDecimal contractSalaryPerDay;
}
