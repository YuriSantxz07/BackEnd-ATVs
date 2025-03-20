package com.example.user.repository;

import com.example.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByNome(String nome);

    User findByNome(String nome);

    boolean existsByCargo(String cargo);

    User findByCargo(String cargo);

    User findByNomeAndCargo(String nome, String cargo);

    boolean existsByNomeAndCargo(String nome, String cargo);
}
