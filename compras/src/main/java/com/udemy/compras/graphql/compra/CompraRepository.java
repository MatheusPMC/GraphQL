package com.udemy.compras.graphql.compra;

import com.udemy.compras.graphql.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {
    List<Compra> findAllByCliente(Cliente c);
}
