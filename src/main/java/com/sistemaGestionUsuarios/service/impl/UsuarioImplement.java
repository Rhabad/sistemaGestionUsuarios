package com.sistemaGestionUsuarios.service.impl;

import com.sistemaGestionUsuarios.models.entity.Usuario;
import com.sistemaGestionUsuarios.service.UsuarioService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioImplement implements UsuarioService {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
