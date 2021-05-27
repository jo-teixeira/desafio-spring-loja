package com.mercadolibre.bootcamp.dtos;

import com.mercadolibre.bootcamp.models.Cliente;
import com.mercadolibre.bootcamp.models.Pedido;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class ClienteDTO {
    @NotNull(message = "Campo obrigatório")
    private String nome;

    @CPF
    private String cpf;

    @NotNull(message = "Campo obrigatório")
    private String email;

    @NotNull(message = "Campo obrigatório")
    private String telefone;

    public ClienteDTO(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cliente toModel() {
        return new Cliente(null, this.nome, this.cpf, this.email, this.telefone, new ArrayList<>());
    }
}
