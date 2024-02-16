package com.sistemaGestionUsuarios.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "direccion")
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_direccion;
    private String pais;
    private String ciudad;

    @OneToMany(mappedBy = "direccion", cascade = CascadeType.ALL)
    private List<Usuario> listaUsuarios;
}
