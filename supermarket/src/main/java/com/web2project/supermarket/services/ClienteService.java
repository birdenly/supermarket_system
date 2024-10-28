package com.web2project.supermarket.services;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
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
        BeanUtils.copyProperties(obj, entity, getNullPropertyNames(obj, "id"));
        return repository.save(entity);
    }

    public static String[] getNullPropertyNames(Object source, String... ignoreProperties) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        for (String ignoreProperty : ignoreProperties) {
            emptyNames.add(ignoreProperty);
        }

        return emptyNames.toArray(new String[0]);
    }
}
