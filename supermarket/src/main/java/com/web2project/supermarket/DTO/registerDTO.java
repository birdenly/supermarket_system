package com.web2project.supermarket.DTO;

import com.web2project.supermarket.Usuarios.Enums.RoleEnum;

public record registerDTO(
    String login,
    String password,
    RoleEnum role
) {

}
