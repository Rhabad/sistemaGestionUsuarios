package com.sistemaGestionUsuarios.service.impl;

import com.sistemaGestionUsuarios.models.dto.UsuarioDto;
import com.sistemaGestionUsuarios.models.entity.Usuario;
import com.sistemaGestionUsuarios.service.UsuarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioImplement implements UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UsuarioDto> findAll() {
        String query = "select distinct u from Usuario u join fetch u.direccion join fetch u.cargo";
        List<Usuario> usuarioList = entityManager.createQuery(query).getResultList();

        List<UsuarioDto> usuarioDtoList = new ArrayList<>();
        for (Usuario usu: usuarioList) {
            usuarioDtoList.add(UsuarioDto.builder()
                            .id(usu.getId())
                            .email(usu.getEmail())
                            .password(usu.getPassword())
                            .telefono(usu.getTelefono())
                            .nombre_completo(usu.getNombre()+" "+usu.getApellido())
                            .direccion(usu.getDireccion().getPais()+", "+usu.getDireccion().getCiudad())
                            .cargo(usu.getCargo().getCargo())
                    .build()
            );
        }

        return usuarioDtoList;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return entityManager.merge(usuario);
    }

    @Override
    public void delete(Integer id) {

    }
}
