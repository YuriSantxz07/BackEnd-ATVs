package com.atividade.banco.controller;

import com.atividade.banco.entity.Produto;
import com.atividade.banco.repository.ProdutoRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository pdRepository;

    @PostMapping("/add")
    public ResponseEntity<Boolean> adicionarProduto(@RequestBody Produto p){
        pdRepository.save(p);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        Optional<Produto> produto = pdRepository.findById(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/verAll")
    public List<Produto> ver(){
        return pdRepository.findAll();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Boolean> atualizar(@PathVariable Integer id, @RequestBody Produto p){
        if(!pdRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        p.setId(id);
        pdRepository.save(p);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id){
        if(!pdRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        pdRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }


}