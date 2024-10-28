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
