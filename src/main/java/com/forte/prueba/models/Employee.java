package com.forte.prueba.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Employee")
@Getter
@Setter
public class Employee extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmployeeId",
            nullable = false,
            unique = true)
    private int employeeId;

    @Column(name = "TaxIdNumber",
            nullable = false,
            unique = true,
            length = 13)
    private String taxIdNumber;

    @Column(name = "Name",
            nullable = false,
            length = 60)
    private String name;

    @Column(name = "LastName",
            nullable = false,
            length = 120)
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "BirthDate",
            nullable = false)
    private Date birthDate;

    @Column(name = "Email",
            nullable = false)
    private String email;

    @Column(name = "CellPhone",
            nullable = false,
            length = 20)
    private String cellPhone;
}
