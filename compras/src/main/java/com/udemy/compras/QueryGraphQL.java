package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository clienteRep;

    // Site para visualizar e testar: http://localhost:8080/graphiql

    // Site para testar o graphql: https://www.graphqlbin.com/v2/6RQ6TM

    //Liberando o playground: http://localhost:8080/playground

    /* Testando as funcoes
{
  hello,
  soma(a:4, b:3),
  client{
    name,
    email
  },
  clients {
    name,
    email
  }
}
     */
    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public Cliente cliente(Long id) {
        return clienteRep.findById(id).orElse(null);
    }

    public List<Cliente> clientes() {
        return clienteRep.findAll();
    }
}
