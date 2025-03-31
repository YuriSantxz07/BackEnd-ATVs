package com.example.backFront.controller;

import com.example.backFront.entity.Produto;
import com.example.backFront.repository.ProdutoRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Produto> addProduto(@RequestBody Produto p){
        Produto produtoBD = produtoRepository.save(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoBD);
    }

    @GetMapping
    public List<Produto> getProdutos(){
        return produtoRepository.findAll();

    }

}
