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

import com.web2project.supermarket.DTO.clienteDTO;
import com.web2project.supermarket.entities.ClienteEntity;
import com.web2project.supermarket.services.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping()
    public ResponseEntity<List<ClienteEntity>> findAll(){
        List<ClienteEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteEntity> findById(@PathVariable Long id){
        ClienteEntity obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping()
    public ResponseEntity<ClienteEntity> insert(@RequestBody clienteDTO obj) {

        ClienteEntity product = new ClienteEntity(obj);

        product = service.insert(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteEntity> update(@PathVariable Long id, @RequestBody clienteDTO obj){

        ClienteEntity Cliente = new ClienteEntity(obj);


        Cliente = service.update(id, Cliente);
        return ResponseEntity.ok().body(Cliente);
    }
    
}
