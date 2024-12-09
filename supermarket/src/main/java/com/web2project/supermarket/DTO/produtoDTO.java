package com.web2project.supermarket.DTO;

import java.time.Instant;

import com.web2project.supermarket.entities.enums.GeneroProduto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record produtoDTO( 
                
        @NotBlank(message = "Nome do produto não pode estar em branco")
        String nomeProduto,
        
        @NotBlank(message = "Marca não pode estar em branco")
        String marca,
        
        @NotNull(message = "Data de fabricação não pode ser nula")
        @PastOrPresent(message = "Data de fabricação deve ser no passado ou presente")
        Instant dataFabricacao,
        
        @NotNull(message = "Data de validade não pode ser nula")
        @Future(message = "Data de validade deve ser no futuro")
        Instant dataValidade,
        
        @NotNull(message = "Gênero do produto não pode ser nulo")
        GeneroProduto genero,
        
        @NotBlank(message = "Lote não pode estar em branco")
        String lote) {

}
