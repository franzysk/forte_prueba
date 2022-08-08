package com.forte.prueba.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Contract")
@Data
public class Contract {
    @Id
    private long contractId;

    private int employeeId;

    private int contractTypeId;

    private Date dateFrom;

    private Date dateTo;

    private float salaryPerDay;

}
