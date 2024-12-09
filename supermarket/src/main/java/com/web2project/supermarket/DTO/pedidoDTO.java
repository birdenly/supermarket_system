package com.web2project.supermarket.DTO;

import jakarta.validation.constraints.NotBlank;

public record pedidoDTO(
        @NotBlank(message = "O código do pedido é obrigatório")
        String codigo
        ) {

}
