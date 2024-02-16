package com.sistemaGestionUsuarios.service;

import com.sistemaGestionUsuarios.models.dto.DireccionDto;
import com.sistemaGestionUsuarios.models.dto.UserWithRolDto;

import java.util.List;

public interface DireccionService {

    List<DireccionDto> findAll();
    void save(DireccionDto direccionDto);
    void delete(Integer id);
    boolean update(Integer id, DireccionDto direccionDto);
}
