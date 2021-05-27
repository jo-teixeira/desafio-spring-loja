package com.mercadolibre.bootcamp.repositories;

import com.mercadolibre.bootcamp.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> { }
