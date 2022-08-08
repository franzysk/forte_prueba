package com.forte.prueba.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ContractType")
@Setter
@Getter
public class ContractType extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ContractTypeId",
            nullable = false,
            unique = true)
    private int contractTypeId;

    @Column(name = "Name",
            nullable = false,
            length = 80)
    private String name;

    @Column(name = "Description")
    private String description;
}
