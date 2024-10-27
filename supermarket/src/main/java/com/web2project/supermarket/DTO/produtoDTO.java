package com.web2project.supermarket.DTO;

import java.time.Instant;

import com.web2project.supermarket.entities.enums.Genero;

public record produtoDTO( 
        String nomeProduto,
        String marca,
        Instant dataFabricacao,
        Instant dataValidade,
        Genero genero,
        String lote) {

}
