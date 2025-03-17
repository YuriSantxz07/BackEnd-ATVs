package com.atividade.banco.repository;

import com.atividade.banco.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByNome(String nome);

    boolean existsByNome(String nome);
}
