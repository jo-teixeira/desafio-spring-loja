package com.mercadolibre.bootcamp.repositories;

import com.mercadolibre.bootcamp.models.Cliente;
import com.mercadolibre.bootcamp.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    public List<Pedido> getByCliente(Cliente cliente);
}
