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
    private ProdutoRepository prRepository;

    @GetMapping
    public List<Produto> getAllProdutos(){
        return prRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getIdProduto(@PathVariable Long id){
        return prRepository.findById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @GetMapping("/{nome}")
//    public ResponseEntity<Produto> getNomeProduto(@PathVariable String nome) {
//        Produto p = prRepository.findByNome(nome);
//        if ((p == null) || !prRepository.existsByNome(nome)){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(p);
//    }

    @PostMapping
    public ResponseEntity<Boolean> addProduto(@RequestBody Produto p){
        prRepository.save(p);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateProduto(@PathVariable Long id, @RequestBody Produto p){
        if(!prRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        p.setId(id);
        prRepository.save(p);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduto(@PathVariable Long id, @RequestBody Produto p){
        if(!prRepository.existsById(id.longValue())){
            return ResponseEntity.notFound().build();
        }
        p.setId(id);
        prRepository.delete(p);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


}
