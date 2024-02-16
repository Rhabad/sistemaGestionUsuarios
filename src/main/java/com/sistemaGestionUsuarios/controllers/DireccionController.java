package com.sistemaGestionUsuarios.controllers;

import com.sistemaGestionUsuarios.models.dto.DireccionDto;
import com.sistemaGestionUsuarios.models.payload.MensajeResponse;
import com.sistemaGestionUsuarios.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DireccionController {

    @Autowired
    private DireccionService direccionService;

    @RequestMapping(value = "/direcciones", method = RequestMethod.GET)
    public ResponseEntity<?> findAllDireccion(){
        List<DireccionDto> listDto = direccionService.findAll();

        if (listDto.isEmpty()){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No hay registro, esta vacio")
                    .object(null)
                    .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("Lista de Direcciones")
                .object(listDto)
                .build()
                , HttpStatus.OK);
    }

    @RequestMapping("/direccion")
    public ResponseEntity<?> create(@RequestBody DireccionDto direccionDto){
        try {
            direccionService.save(direccionDto);
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


    @RequestMapping(value = "/direccion/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        direccionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/direccion/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DireccionDto direccionDto){
        boolean response = direccionService.update(id, direccionDto);

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
