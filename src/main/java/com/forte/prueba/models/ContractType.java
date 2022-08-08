package com.forte.prueba.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ContractType")
@Data
public class ContractType {
    @Id
    private int contractTypeId;

    private String name;

    private String description;
}
