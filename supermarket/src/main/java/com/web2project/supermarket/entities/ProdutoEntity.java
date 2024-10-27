package com.web2project.supermarket.entities;

import java.io.Serializable;
import java.time.Instant;

import com.web2project.supermarket.entities.enums.Genero;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor // conflita com @NoArgsConstructor
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
    private Genero genero;
    private String lote;


}
