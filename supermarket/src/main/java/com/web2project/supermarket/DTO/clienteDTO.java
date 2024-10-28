package com.web2project.supermarket.DTO;

import java.time.Instant;

import com.web2project.supermarket.entities.enums.GeneroPessoa;

public record clienteDTO(
        String nome,
        String cpf,
        GeneroPessoa genero,
        Instant dataNascimento
) {

}
