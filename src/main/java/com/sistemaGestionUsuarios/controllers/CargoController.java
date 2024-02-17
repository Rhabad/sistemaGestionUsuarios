package com.sistemaGestionUsuarios.controllers;

import com.sistemaGestionUsuarios.models.dto.CargoDto;
import com.sistemaGestionUsuarios.models.dto.DireccionDto;
import com.sistemaGestionUsuarios.models.payload.MensajeResponse;
import com.sistemaGestionUsuarios.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @RequestMapping(value = "/cargos", method = RequestMethod.GET)
    public ResponseEntity<?> findAllDireccion(){
        List<CargoDto> listCargo = cargoService.findAll();

        if (listCargo.isEmpty()){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No hay registro, esta vacio")
                    .object(null)
                    .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("Lista de Direcciones")
                .object(listCargo)
                .build()
                , HttpStatus.OK);
    }

    @RequestMapping(value = "/cargo", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody CargoDto cargoDto){
        try {
            cargoService.save(cargoDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Usuario Creado Correctamente")
                    .object(null)
                    .build()
                    , HttpStatus.CREATED);

        } catch (DataAccessException exData){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exData.getMessage()) //exData.getMessage()
                    .object(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/cargo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        cargoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/cargo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody CargoDto cargoDto){
        boolean response = cargoService.update(id, cargoDto);

        if (response){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Usuario Actualizado")
                    .object(null)
                    .build()
                    , HttpStatus.OK);
        } else {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No se encontro Usuario")
                    .object(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
