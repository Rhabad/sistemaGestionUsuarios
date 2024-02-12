package com.sistemaGestionUsuarios.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "cargo")
@Data
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cargo;
    @NotNull
    private String cargo;
    private String descripcion;
    @NotNull
    private boolean activo;

    @OneToMany(mappedBy = "id_cargo_fk", cascade = CascadeType.ALL)
    private Set<Usuario> usuariosSet;
}
