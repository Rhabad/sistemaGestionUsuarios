package com.sistemaGestionUsuarios.controllers;

import com.sistemaGestionUsuarios.models.dto.UserWithRolDto;
import com.sistemaGestionUsuarios.models.dto.UsuarioDto;
import com.sistemaGestionUsuarios.models.payload.MensajeResponse;
import com.sistemaGestionUsuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<?> showAllUser(){
        List<UsuarioDto> listaUsuarios = usuarioService.findAll();

        if (listaUsuarios.isEmpty()){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Registro de Usuario, ¡¡Vacio!!")
                    .object(null)
                    .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("Lista De Usuarios")
                .object(listaUsuarios)
                .build()
        , HttpStatus.OK
        );
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody UserWithRolDto user){

        try {
            usuarioService.save(user);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Usuario Creado Correctamente")
                    .object(null)
                    .build()
                    , HttpStatus.CREATED);

        } catch (DataAccessException exData){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Error al acceder a la base de datos") //exData.getMessage()
                    .object(null)
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }

    @RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
