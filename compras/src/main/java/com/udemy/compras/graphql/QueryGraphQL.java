package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    /*
{
  hello,
  soma(a:4, b:3)
}
     */
    @Autowired
    private ClienteRepository clienteRep;
    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b) {
        return a + b;
    }
}
