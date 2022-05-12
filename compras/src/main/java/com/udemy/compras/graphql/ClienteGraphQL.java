package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.Cliente;
import com.udemy.compras.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver {

    /*
{
  cliente(id:1){
		id,
    nome,
    email
  },
  clientes {
    id,
    nome,
    email
  }
}
     */
    @Autowired
    private ClienteRepository clienteRep;

    public Cliente cliente(Long id) {
        return clienteRep.findById(id).orElse(null);
    }

    public List<Cliente> clientes() {
        return clienteRep.findAll();
    }
}
