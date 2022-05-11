package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    // Site para visualizar e testar: http://localhost:8080/graphiql

    // Site para testar o graphql: https://www.graphqlbin.com/v2/6RQ6TM

    //Liberando o playground: http://localhost:8080/playground
    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b) {
        return a + b;
    }

    public Client client() {
        return new Client("Matheus","matheus@test.com");
    }
}
