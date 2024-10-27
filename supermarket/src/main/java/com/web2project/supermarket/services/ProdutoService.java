package com.web2project.supermarket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2project.supermarket.entities.ProdutoEntity;
import com.web2project.supermarket.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository; 
    
     public List<ProdutoEntity> findAll(){
        return repository.findAll();
    }

    public ProdutoEntity findById(Long id){
        Optional<ProdutoEntity> obj = repository.findById(id);
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
            updateData(entity,obj);
            return repository.save(entity);
    }

    private void updateData(ProdutoEntity entity, ProdutoEntity obj) {
        entity.setNomeProduto(obj.getNomeProduto());
        entity.setMarca(obj.getMarca());
        entity.setDataFabricacao(obj.getDataFabricacao());
        entity.setDataValidade(obj.getDataValidade());
        entity.setGenero(obj.getGenero());
        entity.setLote(obj.getLote());
    }
}
