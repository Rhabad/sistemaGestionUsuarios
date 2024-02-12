package com.sistemaGestionUsuarios.models.entity;

import com.sistemaGestionUsuarios.models.entity.Cargo;
import com.sistemaGestionUsuarios.models.entity.Direccion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private int telefono;
    private String nombre;
    private String apellido;

    @ManyToOne
    private Direccion id_direccion_fk;
    @ManyToOne
    private Cargo id_cargo_fk;

}
