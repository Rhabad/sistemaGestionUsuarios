package com.sistemaGestionUsuarios.service;

import com.sistemaGestionUsuarios.models.dto.CargoDto;
import com.sistemaGestionUsuarios.models.dto.DireccionDto;

import java.util.List;

public interface CargoService {

    List<CargoDto> findAll();
    void save(CargoDto cargoDto);
    void delete(Integer id);
    boolean update(Integer id, CargoDto cargoDto);
}
