package com.sistemaGestionUsuarios.service;

import com.sistemaGestionUsuarios.models.dto.UserWithRolDto;
import com.sistemaGestionUsuarios.models.dto.UsuarioDto;
import com.sistemaGestionUsuarios.models.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> findAll();
    void save(UserWithRolDto user);
    void delete(Integer id);


}
