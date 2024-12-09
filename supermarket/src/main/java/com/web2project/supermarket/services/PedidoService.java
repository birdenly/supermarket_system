package com.web2project.supermarket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web2project.supermarket.entities.ClienteEntity;
import com.web2project.supermarket.entities.PedidoEntity;
import com.web2project.supermarket.entities.ProdutoEntity;
import com.web2project.supermarket.repositories.ClienteRepository;
import com.web2project.supermarket.repositories.PedidoRepository;
import com.web2project.supermarket.repositories.ProdutoRepository;
import com.web2project.supermarket.utils.BeanUtilsHelp;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository; 

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    
    
     public List<PedidoEntity> findAll(){
        return pedidoRepository.findAll();
    }

    public PedidoEntity findById(Long id){
        Optional<PedidoEntity> obj = pedidoRepository.findById(id);
        
        if (!obj.get().isAtivo()) {
            throw new RuntimeException("Pedido inativo");
        }
        
		return obj.get();
    }

    public PedidoEntity insert(PedidoEntity obj){
        return pedidoRepository.save(obj);
    }

    public void delete(Long id){
        pedidoRepository.deleteById(id);
    }

    public PedidoEntity update(Long id, PedidoEntity obj){
        PedidoEntity entity = pedidoRepository.getReferenceById(id);

        if (!entity.isAtivo()) {
            throw new RuntimeException("Pedido inativo");
        }

        BeanUtils.copyProperties(obj, entity, BeanUtilsHelp.getNullPropertyNames(obj));
        return pedidoRepository.save(entity);
    }

    public PedidoEntity deleteLogic(Long id) {
        Optional<PedidoEntity> pedido;
        if (pedidoRepository.existsById(id)) {
            pedido = pedidoRepository.findById(id);
            pedido.get().desativar();
            pedidoRepository.save(pedido.get());

            return pedido.get();
        } else {
            throw new RuntimeException("Pedido inativo");
        }
    }

    public List<PedidoEntity> findAllAtivo(){
        return pedidoRepository.findAllByAtivoTrue();
    }

    public List<ProdutoEntity> addProduct (Long idPedido, Long idProduto) {
        Optional<PedidoEntity> pedido = pedidoRepository.findById(idPedido);
        Optional<ProdutoEntity> produto = produtoRepository.findById(idProduto);

        if (pedido.isEmpty() || produto.isEmpty()) {
            return null;
        }

        pedido.get().getProdutos().add(produto.get());
        pedidoRepository.save(pedido.get());
        return pedido.get().getProdutos();
    }

    public List<ProdutoEntity> removeProduct (Long idPedido, Long idProduto) {
        Optional<PedidoEntity> pedido = pedidoRepository.findById(idPedido);
        Optional<ProdutoEntity> produto = produtoRepository.findById(idProduto);

        if (pedido.isEmpty() || produto.isEmpty()) {
            return null;
        }

        pedido.get().getProdutos().remove(produto.get());
        pedidoRepository.save(pedido.get());
        return pedido.get().getProdutos();
    }

    public PedidoEntity addCliente (Long idPedido, Long idCliente) {
        Optional<PedidoEntity> pedido = pedidoRepository.findById(idPedido);
        Optional<ClienteEntity> cliente = clienteRepository.findById(idCliente);

        if (pedido.isEmpty() || cliente.isEmpty()) {
            return null;
        }

        pedido.get().setCliente(cliente.get());
        pedidoRepository.save(pedido.get());
        return pedido.get();
    }
}