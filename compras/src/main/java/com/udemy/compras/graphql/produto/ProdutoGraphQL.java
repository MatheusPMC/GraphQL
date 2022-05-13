package com.udemy.compras.graphql.produto;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService produtoService;

    public Produto produto(Long id) {
        return produtoService.findById(id);
    }

    public List<Produto> produtos() {
        return produtoService.findAll();
    }

    public Produto saveProduto(ProdutoInput input) {
        ModelMapper m = new ModelMapper();
        Produto p = m.map(input, Produto.class);
        return produtoService.save(p);
    }

    public Boolean deleteProduto(Long id) {
         return produtoService.deleteById(id);
    }
}
