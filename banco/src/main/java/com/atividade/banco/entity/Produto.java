package com.atividade.banco.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Produto {
    @Id
    private Long id;
    private String nome;
    private double precoDeCompra;
    private double precoDeVenda;
    private String fornecedor;
    private boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(double precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public double getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(double precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
