package com.web2project.supermarket.entities;

import java.io.Serializable;
import java.time.Instant;

import com.web2project.supermarket.DTO.produtoDTO;
import com.web2project.supermarket.entities.enums.GeneroProduto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
//@AllArgsConstructor causava erro quando dava o getAll, usei manualmente
@Entity
@Table(name = "produtos")
public class ProdutoEntity implements Serializable{ 

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private String marca;
    private Instant dataFabricacao;
    private Instant dataValidade;
    private GeneroProduto genero;
    private String lote;

    public ProdutoEntity(produtoDTO produto) {
        this.nomeProduto = produto.nomeProduto();
        this.marca = produto.marca();
        this.dataFabricacao = produto.dataFabricacao();
        this.dataValidade = produto.dataValidade();
        this.genero = produto.genero();
        this.lote = produto.lote();
        
    }

    public ProdutoEntity() {
    }

    

}
