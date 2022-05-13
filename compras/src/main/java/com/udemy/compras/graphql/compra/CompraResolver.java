package com.udemy.compras.graphql.compra;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.compras.graphql.cliente.Cliente;
import com.udemy.compras.graphql.cliente.ClienteService;
import com.udemy.compras.graphql.produto.Produto;
import com.udemy.compras.graphql.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Cliente cliente(Compra c) {
        return clienteService.findById(c.getCliente().getId());
    }

    public Produto produto(Compra c) {
        return produtoService.findById(c.getProduto().getId());
    }
}
