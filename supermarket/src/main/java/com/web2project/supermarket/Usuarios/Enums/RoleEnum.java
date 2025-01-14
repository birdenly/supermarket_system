package com.web2project.supermarket.Usuarios.Enums;

public enum RoleEnum {
    ADMIN("admin"),
    USUARIO("users");
    
    String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

}
