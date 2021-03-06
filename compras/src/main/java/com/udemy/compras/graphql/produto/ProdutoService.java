package com.udemy.compras.graphql.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository rep;

    public Produto findById(Long id) {
        return rep.findById(id).orElse(null);
    }

    public List<Produto> findAll() {
        return rep.findAll();
    }

    @Transactional
    public Produto save(Produto p) {
        return rep.save(p);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(rep.findById(id).isPresent()){
            rep.deleteById(id);
            return true;
        }
        return false;
    }
}
