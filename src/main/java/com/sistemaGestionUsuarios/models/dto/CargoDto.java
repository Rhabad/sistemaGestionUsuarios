package com.sistemaGestionUsuarios.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CargoDto {
    private Integer id_cargo;
    private String cargo;
    private String descripcion;
    private boolean activo;
}
