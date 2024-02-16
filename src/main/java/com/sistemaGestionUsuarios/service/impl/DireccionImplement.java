package com.sistemaGestionUsuarios.service.impl;

import com.sistemaGestionUsuarios.models.dto.DireccionDto;
import com.sistemaGestionUsuarios.models.dto.UserWithRolDto;
import com.sistemaGestionUsuarios.models.entity.Cargo;
import com.sistemaGestionUsuarios.models.entity.Direccion;
import com.sistemaGestionUsuarios.models.entity.Usuario;
import com.sistemaGestionUsuarios.service.DireccionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DireccionImplement implements DireccionService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DireccionDto> findAll() {
        String query = "select d from Direccion d";
        List<Direccion> direcList = entityManager.createQuery(query).getResultList();

        List<DireccionDto> direcListDto = new ArrayList<>();

        for (Direccion dir: direcList) {
            direcListDto.add(DireccionDto.builder()
                            .id_direccion(dir.getId_direccion())
                            .pais(dir.getPais())
                            .ciudad(dir.getCiudad())
                    .build());
        }

        return direcListDto;
    }

    @Override
    @Transactional
    public void save(DireccionDto direccionDto) {
        Direccion dir = Direccion.builder()
                .pais(direccionDto.getPais())
                .ciudad(direccionDto.getCiudad())
                .build();

        entityManager.persist(dir);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Direccion dir = entityManager.find(Direccion.class, id);
        entityManager.remove(dir);
    }

    @Override
    @Transactional
    public boolean update(Integer id, DireccionDto direccionDto) {
        Direccion dir = entityManager.find(Direccion.class, id);

        //actualizamos
        if (dir != null){
            dir.setPais(direccionDto.getPais());
            dir.setCiudad(direccionDto.getCiudad());

            entityManager.merge(dir);
            return true;
        } else {
            return false;
        }
    }
}
