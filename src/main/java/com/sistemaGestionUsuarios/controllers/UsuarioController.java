package com.sistemaGestionUsuarios.controllers;

import com.sistemaGestionUsuarios.models.dto.UsuarioDto;
import com.sistemaGestionUsuarios.models.entity.Usuario;
import com.sistemaGestionUsuarios.models.payload.MensajeResponse;
import com.sistemaGestionUsuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ResponseEntity<?> showAllUser(){
        List<UsuarioDto> listaUsuarios = usuarioService.findAll();
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("Lista De Usuarios")
                .object(listaUsuarios)
                .build()
        , HttpStatus.OK
        );
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Usuario usuario){
        return null;
    }

}
