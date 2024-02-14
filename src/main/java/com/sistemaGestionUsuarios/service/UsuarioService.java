package com.sistemaGestionUsuarios.service;

import com.sistemaGestionUsuarios.models.dto.UsuarioDto;
import com.sistemaGestionUsuarios.models.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> findAll();
    Usuario save(Usuario usuario);
    void delete(Integer id);


}
