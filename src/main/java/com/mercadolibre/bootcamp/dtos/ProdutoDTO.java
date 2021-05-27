package com.mercadolibre.bootcamp.dtos;

import com.mercadolibre.bootcamp.models.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoDTO {
    @NotBlank(message = "Campo obrigatório")
    private String descricao;

    @NotBlank(message = "Campo obrigatório")
    private String cor;

    @NotNull(message = "Campo obrigatório")
    private Integer quantidade;

    @NotNull(message = "Campo obrigatório")
    private Double preco;

    public ProdutoDTO(String descricao, String cor, Integer quantidade, Double preco) {
        this.descricao = descricao;
        this.cor = cor;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto toModel() {
        return new Produto(null, this.descricao, this.cor, this.quantidade, this.preco);
    }
}
