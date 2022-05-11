package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

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

    public Client client() {
        return new Client("Matheus","matheus@test.com");
    }

    public List<Client> clients() {
        List<Client> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Client("Client " +1, "email"+i+"@test.com"));
        }
        return list;
    }
}
