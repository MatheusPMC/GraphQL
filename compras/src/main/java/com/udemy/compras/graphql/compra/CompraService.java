package com.udemy.compras.graphql.compra;

import com.udemy.compras.graphql.cliente.Cliente;
import com.udemy.compras.graphql.exceptions.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    //    @Autowired
//    CacheManager ch;

    @Autowired
    private CompraRepository rep;

    public Compra findById(Long id) {
        return rep.findById(id).orElse(null);
    }

    @Cacheable("compras")
    public List<Compra> findAll(Pageable pageable){
//        for (int i = 0; i < ch.getCacheNames().size(); i++) {
//            String s = new ArrayList<String>(ch.getCacheNames()).get(i);
//            Cache c = ch.getCache(s);
//            System.out.println(c);
//        }
        return rep.findAll(pageable).getContent();
    }

    @Transactional
    //    @CacheEvict(value = "compras",key = "#c.cliente.id")
    public Compra save(Compra c) {
        if (c.getQuantidade() > 100) {
            throw new DomainException("Não é possível fazer uma compra com mais de 100 items");
        }
        return rep.save(c);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(rep.findById(id).isPresent()){
            rep.deleteById(id);
            return true;
        }
        return false;
    }

    //    @Cacheable(value = "comprasByCliente", key = "#c.id")
    public List<Compra> findAllByCliente(Cliente c) {
        return rep.findAllByCliente(c);
    }
}
