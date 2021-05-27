package com.mercadolibre.bootcamp.services;

import com.mercadolibre.bootcamp.dtos.PedidoDTO;
import com.mercadolibre.bootcamp.dtos.ProdutoDTO;
import com.mercadolibre.bootcamp.models.Cliente;
import com.mercadolibre.bootcamp.models.Pedido;
import com.mercadolibre.bootcamp.models.Produto;
import com.mercadolibre.bootcamp.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    public Double calculaValorTotal(List<Produto> produtos) {
        return produtos.stream().mapToDouble(produto -> produto.getPreco() * produto.getQuantidade()).reduce(0, (total, valor) -> total + valor);
    }

    public Pedido create(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getByCliente(Integer id) {
        Cliente cliente = clienteService.findById(id);

        return pedidoRepository.getByCliente(cliente);
    }
}
