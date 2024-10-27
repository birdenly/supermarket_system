package com.web2project.supermarket.DTO;

import java.time.Instant;

public record clienteDTO(
        String nome,
        String cpf,
        String genero,
        Instant dataNascimento
) {

}
