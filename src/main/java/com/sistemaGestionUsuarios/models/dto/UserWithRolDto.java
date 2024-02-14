package com.sistemaGestionUsuarios.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserWithRolDto {
    // user
    private String email;
    private String password;
    private int telefono;
    private String nombre;
    private String apellido;

    //rol
    private Integer direccion_id;
    private Integer cargo_id;
}
