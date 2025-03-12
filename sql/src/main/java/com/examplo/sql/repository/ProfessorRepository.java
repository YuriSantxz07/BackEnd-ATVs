package com.examplo.sql.repository;

import com.examplo.sql.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    Professor findByNome(String nome);

    boolean existsByNome(String nome);
}
