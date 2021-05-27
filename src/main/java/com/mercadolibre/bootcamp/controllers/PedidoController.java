package com.mercadolibre.bootcamp.controllers;

import com.mercadolibre.bootcamp.dtos.PedidoDTO;
import com.mercadolibre.bootcamp.models.Cliente;
import com.mercadolibre.bootcamp.models.Pedido;
import com.mercadolibre.bootcamp.models.Produto;
import com.mercadolibre.bootcamp.services.ClienteService;
import com.mercadolibre.bootcamp.services.PedidoService;
import com.mercadolibre.bootcamp.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody @Valid PedidoDTO pedidoDTO) {
        List<Produto> produtos =  produtoService.findAllByIds(pedidoDTO.getProdutos());
        Cliente cliente = clienteService.findById(pedidoDTO.getIdCliente());
        Pedido pedido = pedidoDTO.toModel(produtos, cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.create(pedido));
    }
}
