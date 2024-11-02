package com.web2project.supermarket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2project.supermarket.entities.ProdutoEntity;
import com.web2project.supermarket.repositories.ProdutoRepository;
import com.web2project.supermarket.utils.BeanUtilsHelp;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository; 
    
     public List<ProdutoEntity> findAll(){
        return repository.findAll();
    }

    public ProdutoEntity findById(Long id){
        Optional<ProdutoEntity> obj = repository.findById(id);

        if (!obj.get().isAtivo()) {
            throw new RuntimeException("Produto inativo");
        }

		return obj.get();
    }

    public ProdutoEntity insert(ProdutoEntity obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public ProdutoEntity update(Long id, ProdutoEntity obj){
        ProdutoEntity entity = repository.getReferenceById(id);
        
        if (!entity.isAtivo()) {
            throw new RuntimeException("Produto inativo");
        }

        BeanUtils.copyProperties(obj, entity, BeanUtilsHelp.getNullPropertyNames(obj));
        return repository.save(entity);
    }

    public ProdutoEntity deleteLogic(Long id) {
        Optional<ProdutoEntity> produto;
        if (repository.existsById(id)) {
            produto = repository.findById(id);
            produto.get().desativar();
            repository.save(produto.get());

            return produto.get();
        } else {
            throw new RuntimeException("Produto inativo");
        }
    }

    public List<ProdutoEntity> findAllAtivo(){
        return repository.findAllByAtivoTrue();
    }

    
}
