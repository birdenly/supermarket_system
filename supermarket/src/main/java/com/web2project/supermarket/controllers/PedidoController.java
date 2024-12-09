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

import com.web2project.supermarket.DTO.pedidoDTO;
import com.web2project.supermarket.entities.PedidoEntity;
import com.web2project.supermarket.entities.ProdutoEntity;
import com.web2project.supermarket.services.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoService service;

    @GetMapping()
    public ResponseEntity<List<PedidoEntity>> findAll(){
        List<PedidoEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        PedidoEntity obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping()
    public ResponseEntity<PedidoEntity> insert(@RequestBody pedidoDTO obj) {

        PedidoEntity product = new PedidoEntity(obj);

        product = service.insert(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody pedidoDTO obj){

        PedidoEntity produto = new PedidoEntity(obj);

        produto = service.update(id, produto);

        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("deleteLogic/{id}")
    public ResponseEntity<Object> deleteLogic(@PathVariable Long id) {
        PedidoEntity produto = service.deleteLogic(id);

        return ResponseEntity.ok().body(produto); 
    }
    
    @GetMapping("getAllByAtivo")
    public ResponseEntity<Object> getAllByAtivo() {
        return ResponseEntity.ok().body(service.findAllAtivo());
    }

    @PutMapping("/{idPedido}/addProduto/{idProduto}")
    public ResponseEntity<Object> addProduct(@PathVariable Long idPedido, @PathVariable Long idProduto) {

        List<ProdutoEntity> produtos = service.addProduct(idPedido, idProduto);

        return ResponseEntity.ok().body(produtos);
    }

    @PutMapping("/{idPedido}/deleteProduto/{idProduto}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long idPedido, @PathVariable Long idProduto) {
        List<ProdutoEntity> produtos = service.removeProduct(idPedido, idProduto);

        return ResponseEntity.ok().body(produtos);
    }

    @PutMapping("/{idPedido}/addCliente/{idCliente}")
    public ResponseEntity<Object> addClient(@PathVariable Long idPedido, @PathVariable Long idCliente) {
        PedidoEntity produto = service.addCliente(idPedido, idCliente);

        return ResponseEntity.ok().body(produto);
    }
}

