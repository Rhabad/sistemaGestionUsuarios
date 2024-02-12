package com.sistemaGestionUsuarios.models.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "direccion")
@Data
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_direccion;
    @Column
    private String pais;
    private String ciudad;

    @OneToMany(mappedBy = "id_direccion_fk", cascade = CascadeType.ALL)
    private List<Usuario> listaUsuarios;
}
