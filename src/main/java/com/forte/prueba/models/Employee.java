package com.forte.prueba.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    private int employeeId;

    private String taxIdNumber;

    private String name;

    private String lastname;

    private Date birthDate;

    private String email;

    private String cellPhone;
}
