package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

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
    private ClienteService clienteService;

    public Cliente cliente(Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clientes() {
        return clienteService.findAll();
    }

    public Cliente saveCliente(Long id, String nome, String email) {
        Cliente c = new Cliente(id, nome, email);
        return clienteService.save(c);
    }

    public Boolean deleteCliente(Long id) {
         return clienteService.deleteById(id);
    }
}
