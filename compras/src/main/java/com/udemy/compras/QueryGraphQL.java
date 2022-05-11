package com.udemy.compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    // Site para visualizar e testar: http://localhost:8080/graphiql
    public String hello() {
        return "Hello GraphQL";
    }

    public int soma(int a, int b) {
        return a + b;
    }
}
