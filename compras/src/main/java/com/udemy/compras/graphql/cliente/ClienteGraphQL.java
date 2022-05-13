package com.udemy.compras.graphql.cliente;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
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

mutation {
  saveCliente(cliente:{id:4,nome: "Matheus Marques4", email: "matheustest@test.com"}){
   id,nome,email
  }
}

mutation{
  deleteCliente(id:10)
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

    public Cliente saveCliente(ClienteInput input) {
//        Cliente c = new Cliente();
//        c.setId(input.getId());
//        c.setNome(input.getNome());
//        c.setEmail(input.getEmail());
        ModelMapper m = new ModelMapper();
        Cliente c = m.map(input, Cliente.class);
        return clienteService.save(c);
    }

    public Boolean deleteCliente(Long id) {
         return clienteService.deleteById(id);
    }
}
