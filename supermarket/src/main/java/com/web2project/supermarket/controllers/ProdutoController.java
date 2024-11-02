package com.web2project.supermarket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web2project.supermarket.DTO.produtoDTO;
import com.web2project.supermarket.entities.ProdutoEntity;
import com.web2project.supermarket.services.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping()
    public ResponseEntity<List<ProdutoEntity>> findAll(){
        List<ProdutoEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        ProdutoEntity obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping()
    public ResponseEntity<ProdutoEntity> insert(@RequestBody produtoDTO obj) {

        ProdutoEntity product = new ProdutoEntity(obj);

        product = service.insert(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody produtoDTO obj){

        ProdutoEntity produto = new ProdutoEntity(obj);

        produto = service.update(id, produto);

        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("deleteLogic/{id}")
    public ResponseEntity<Object> deleteLogic(@PathVariable Long id) {
        ProdutoEntity produto = service.deleteLogic(id);

        return ResponseEntity.ok().body(produto); 
    }
    
    @GetMapping("getAllByAtivo")
    public ResponseEntity<Object> getAllByAtivo() {
        return ResponseEntity.ok().body(service.findAllAtivo());
    }
}
