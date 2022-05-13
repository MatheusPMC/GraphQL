package com.udemy.compras.graphql.cliente;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.graphql.compra.Compra;
import com.udemy.compras.graphql.compra.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    CompraService compraService;

    public List<Compra> compras(Cliente c) {
        return compraService.findAllByCliente(c);
    }
}
