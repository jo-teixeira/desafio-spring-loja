package com.mercadolibre.bootcamp.controllers;

import com.mercadolibre.bootcamp.dtos.ProdutoDTO;
import com.mercadolibre.bootcamp.models.Produto;
import com.mercadolibre.bootcamp.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody @Valid ProdutoDTO produtoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.create(produtoDTO));
    }
}
