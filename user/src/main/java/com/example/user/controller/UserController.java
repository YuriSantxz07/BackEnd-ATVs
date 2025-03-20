package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User userBd = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userBd);
    }
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<>("Nenhum usuário cadastrado.", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return userRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<User> getUserByNome(@PathVariable String nome){
        User user = userRepository.findByNome(nome);
        if(user == null ||!userRepository.existsByNome(nome)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<User> getUserByCargo(@PathVariable String cargo){
        User user = userRepository.findByCargo(cargo);
        if(user == null ||!userRepository.existsByCargo(cargo)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUserByNomeAndCargo(@RequestParam String nome, @RequestParam String cargo){
        User user = userRepository.findByNomeAndCargo(nome, cargo);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUser(@PathVariable Long id, @RequestBody User user){
        if (!userRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        userRepository.save(user);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();

        }
        userRepository.deleteById(id);
        return null;
    }
}

