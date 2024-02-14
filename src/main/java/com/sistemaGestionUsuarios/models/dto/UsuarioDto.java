package com.sistemaGestionUsuarios.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
    // Usuario
    private Integer id;
    private String email;
    private String password;
    private int telefono;
    private String nombre_completo;
    // Direccion
    private String direccion;

    // Cargo
    private String cargo;
}
