package com.udemy.compras.graphql.compra;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.graphql.cliente.Cliente;
import com.udemy.compras.graphql.cliente.ClienteInput;
import com.udemy.compras.graphql.cliente.ClienteService;
import com.udemy.compras.graphql.produto.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    /*
mutation {
  saveCompra(compra:{
    clienteId:5,
    produtoId:2,
    quantidade:20,
    status:"Ok"
  }) {
    id,quantidade,status
  }
}

{
  compra(id:1){
    id, quantidade, status,
    cliente {
   		id, nome
  	},
    produto {
      id, nome, valor
    }
  }
}

{
  compras {
    id, quantidade, status,
    cliente {
   		id, nome
  	},
    produto {
      id, nome, valor
    }
  }
}

mutation {
  deleteCompra(id: 2)
}
     */
    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Compra compra(Long id) {
        return compraService.findById(id);
    }

    public List<Compra> getCompras(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return compraService.findAll(pageable);
    }

    public Compra saveCompra(CompraInput input) {
        ModelMapper m = new ModelMapper();
        Compra c = m.map(input, Compra.class);

        c.setData(new Date());

        c.setCliente(clienteService.findById(input.getClienteId()));
        c.setProduto(produtoService.findById(input.getProdutoId()));
        return compraService.save(c);
    }

    public Boolean deleteCompra(Long id) {
         return compraService.deleteById(id);
    }
}
