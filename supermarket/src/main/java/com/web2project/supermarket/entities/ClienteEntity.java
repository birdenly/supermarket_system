package com.web2project.supermarket.entities;

import java.io.Serializable;
import java.time.Instant;

import com.web2project.supermarket.DTO.clienteDTO;
import com.web2project.supermarket.entities.enums.GeneroPessoa;

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
@Table(name = "clientes")
public class ClienteEntity implements Serializable{ 

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private GeneroPessoa genero;
    private Instant dataNascimento;
    private boolean ativo = true;

    public ClienteEntity(clienteDTO cliente) {
        this.nome = cliente.nome();
        this.cpf = cliente.cpf();
        this.genero = cliente.genero();
        this.dataNascimento = cliente.dataNascimento();
        
    }

    public ClienteEntity() {
    }

    public void desativar() {
        ativo = false;
    }
    public void ativar() {
        ativo = true;
    }

}