package com.mercadolibre.bootcamp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @ManyToMany()
    @JoinTable(name = "PEDIDO_PRODUTOS", joinColumns = @JoinColumn(name = "PEDIDO_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUTO_ID"))
    private List<Produto> produtos;

    @NotNull(message = "Campo obrigatório")
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    @JsonIgnore
    private Cliente cliente;

    public Pedido(Integer id, List<Produto> produtos, Double valorTotal, Cliente cliente) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
    }

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente idCliente) {
        this.cliente = idCliente;
    }
}
