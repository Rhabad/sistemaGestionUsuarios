package com.sistemaGestionUsuarios.service.impl;

import com.sistemaGestionUsuarios.models.entity.Usuario;
import com.sistemaGestionUsuarios.service.UsuarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioImplement implements UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> findAll() {
        String query = "select u from Usuario u";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return entityManager.merge(usuario);
    }

    @Override
    public void delete(Integer id) {

    }
}
