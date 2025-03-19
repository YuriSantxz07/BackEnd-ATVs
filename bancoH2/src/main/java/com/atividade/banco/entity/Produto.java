package com.atividade.banco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data

public class Produto {
    @Id
    private Integer id;
    private String nome;
    private double precoDeCompra;
    private double precoDeVenda;
    private String fornecedor;
    private boolean status;

}
