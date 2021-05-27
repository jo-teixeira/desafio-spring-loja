package com.mercadolibre.bootcamp.dtos;

import com.mercadolibre.bootcamp.models.Cliente;
import com.mercadolibre.bootcamp.models.Pedido;
import com.mercadolibre.bootcamp.models.Produto;
import com.mercadolibre.bootcamp.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PedidoDTO {

    private List<Integer> produtos;

    @NotNull(message = "Campo obrigatório")
    private Integer idCliente;

    public PedidoDTO(List<Integer> produtos, Integer idCliente) {
        this.produtos = produtos;
        this.idCliente = idCliente;
    }

    public List<Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Integer> produtos) {
        this.produtos = produtos;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Pedido toModel(List<Produto> produtos, Cliente cliente) {
        Double valorTotal = produtos.stream().mapToDouble(produto -> produto.getPreco() * produto.getQuantidade()).reduce(0, (total, valor) -> total + valor);

        return new Pedido(null, produtos, valorTotal, cliente);
    }
}
