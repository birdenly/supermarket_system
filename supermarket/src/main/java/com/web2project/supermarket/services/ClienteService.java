package com.web2project.supermarket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2project.supermarket.entities.ClienteEntity;
import com.web2project.supermarket.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository; 
    
     public List<ClienteEntity> findAll(){
        return repository.findAll();
    }

    public ClienteEntity findById(Long id){
        Optional<ClienteEntity> obj = repository.findById(id);
		return obj.get();
    }

    public ClienteEntity insert(ClienteEntity obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public ClienteEntity update(Long id, ClienteEntity obj){
            ClienteEntity entity = repository.getReferenceById(id);
            updateData(entity,obj);
            return repository.save(entity);
    }

    private void updateData(ClienteEntity entity, ClienteEntity obj) {
        entity.setNome(obj.getNome());
        entity.setCpf(obj.getCpf());
        entity.setGenero(obj.getGenero());
        entity.setDataNascimento(obj.getDataNascimento());
    }
}
