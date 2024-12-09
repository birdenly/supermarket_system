package com.web2project.supermarket.entities;

import java.io.Serializable;
import java.util.List;

import com.web2project.supermarket.DTO.pedidoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
//@AllArgsConstructor causava erro quando dava o getAll, usei manualmente
@Entity
@Table(name = "pedidos")
public class PedidoEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;

    @ManyToMany()
    @JoinTable(
            name = "pedidos_produtos",
            joinColumns = @JoinColumn(name = "pedidos_id"),
            inverseJoinColumns = @JoinColumn(name = "produtos_id")
    )
    private List<ProdutoEntity> produtos;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClienteEntity cliente;
    private boolean ativo = true;

    public PedidoEntity(pedidoDTO pedido) {
        this.codigo = pedido.codigo();

    }

    public PedidoEntity() {
    }

    public void desativar() {
        this.ativo = false;
    }
    public void ativar() {
        this.ativo = true;
    }

}
