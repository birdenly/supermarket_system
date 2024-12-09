package com.web2project.supermarket.DTO;

import java.time.Instant;

import org.hibernate.validator.constraints.br.CPF;

import com.web2project.supermarket.entities.enums.GeneroPessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record clienteDTO(
        @NotBlank(message = "Nome não pode estar em branco")
        String nome,

        @NotBlank(message = "CPF não pode estar em branco")
        @CPF(message = "CPF invalido")
        String cpf,

        @NotNull(message = "Genero não pode ser nula")
        GeneroPessoa genero,

        @NotNull(message = "Data de Nascimento não pode ser nula")
        @PastOrPresent(message = "Data de Nascimento tem que ser no passado ou presente")
        Instant dataNascimento
) {

}