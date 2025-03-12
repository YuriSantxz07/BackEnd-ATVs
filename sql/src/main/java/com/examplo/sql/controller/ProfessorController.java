package com.examplo.sql.controller;

import com.examplo.sql.entity.Professor;
import com.examplo.sql.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository pfRepository;

    @PostMapping
    public ResponseEntity<Boolean> addProfessor(@RequestBody Professor p){
        pfRepository.save(p);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @GetMapping
    public List<Professor> verProfessores(){
        return pfRepository.findAll();
    }

    @GetMapping("/ver/{nome}")
    public ResponseEntity<Professor> verIdProfessor(@PathVariable String nome) {
        Professor professor = pfRepository.findByNome(nome);
        if ((professor == null) || !pfRepository.existsByNome(nome)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professor);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateProfessor(@PathVariable Integer id, @RequestBody Professor p){
        if (!pfRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        p.setId(id);
        pfRepository.save(p);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletarProfessor(@PathVariable Integer id, @RequestBody Professor p){
        if (!pfRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        p.setId(id);
        pfRepository.delete(p);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
