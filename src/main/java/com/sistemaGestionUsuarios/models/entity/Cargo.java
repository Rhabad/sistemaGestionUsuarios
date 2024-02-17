package com.sistemaGestionUsuarios.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cargo")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cargo;
    @NotNull
    private String cargo;
    private String descripcion;
    @NotNull
    private boolean activo;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Usuario> usuariosList;
}
