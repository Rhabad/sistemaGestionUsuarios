package com.sistemaGestionUsuarios.service.impl;

import com.sistemaGestionUsuarios.models.dto.CargoDto;
import com.sistemaGestionUsuarios.models.entity.Cargo;
import com.sistemaGestionUsuarios.models.entity.Direccion;
import com.sistemaGestionUsuarios.service.CargoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CargoImplement implements CargoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CargoDto> findAll() {
        String query = "Select c from Cargo c";
        List<Cargo> listCargo = entityManager.createQuery(query).getResultList();

        List<CargoDto> listCargoDto = new ArrayList<>();
        for (Cargo car: listCargo) {
            listCargoDto.add(CargoDto.builder()
                            .id_cargo(car.getId_cargo())
                            .cargo(car.getCargo())
                            .descripcion(car.getDescripcion())
                            .activo(car.isActivo())
                    .build());
        }

        return listCargoDto;
    }

    @Override
    @Transactional
    public void save(CargoDto cargoDto) {
        Cargo car = Cargo.builder()
                .cargo(cargoDto.getCargo())
                .descripcion(cargoDto.getDescripcion())
                .activo(cargoDto.isActivo())
                .build();

        entityManager.persist(car);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Cargo car = entityManager.find(Cargo.class, id);
        entityManager.remove(car);
    }

    @Override
    @Transactional
    public boolean update(Integer id, CargoDto cargoDto) {
        Cargo car = entityManager.find(Cargo.class, id);

        //actualizamos
        if (car != null){
            car.setCargo(cargoDto.getCargo());
            car.setDescripcion(cargoDto.getDescripcion());
            car.setActivo(cargoDto.isActivo());

            entityManager.merge(car);
            return true;
        } else {
            return false;
        }
    }
}
