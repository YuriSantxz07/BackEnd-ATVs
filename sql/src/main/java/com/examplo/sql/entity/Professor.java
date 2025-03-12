package com.examplo.sql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Professor {

    @Id
    private Integer id;
    private String nome;
    private Integer idade;
    private Double salario;
}
