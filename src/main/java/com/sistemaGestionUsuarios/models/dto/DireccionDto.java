package com.sistemaGestionUsuarios.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DireccionDto {
    private Integer id_direccion;
    private String pais;
    private String ciudad;
}
