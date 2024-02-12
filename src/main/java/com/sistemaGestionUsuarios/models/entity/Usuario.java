package com.sistemaGestionUsuarios.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_direccion_fk")
    private Direccion id_direccion_fk;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_cargo_fk")
    private Cargo id_cargo_fk;

}
