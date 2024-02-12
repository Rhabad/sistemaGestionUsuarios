package com.sistemaGestionUsuarios.service;

import com.sistemaGestionUsuarios.models.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    void delete(Integer id);


}
