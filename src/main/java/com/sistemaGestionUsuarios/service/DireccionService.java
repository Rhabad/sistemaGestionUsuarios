package com.sistemaGestionUsuarios.service;

import com.sistemaGestionUsuarios.models.dto.UserWithRolDto;
import com.sistemaGestionUsuarios.models.dto.UsuarioDto;

import java.util.List;

public interface DireccionService {

    List<UsuarioDto> findAll();
    void save(UserWithRolDto user);
    void delete(Integer id);
    boolean update(Integer id, UserWithRolDto user);
}
