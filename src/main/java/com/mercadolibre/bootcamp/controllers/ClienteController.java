package com.mercadolibre.bootcamp.controllers;

import com.mercadolibre.bootcamp.dtos.ClienteDTO;
import com.mercadolibre.bootcamp.models.Cliente;
import com.mercadolibre.bootcamp.models.Pedido;
import com.mercadolibre.bootcamp.services.ClienteService;
import com.mercadolibre.bootcamp.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody @Valid ClienteDTO clienteDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.create(clienteDTO.toModel()));
    }

    @GetMapping("/{id}/pedidos")
    public ResponseEntity<List<Pedido>> getPedidos(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.getByCliente(id));
    }
}
