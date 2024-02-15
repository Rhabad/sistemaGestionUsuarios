package com.sistemaGestionUsuarios.service.impl;

import com.sistemaGestionUsuarios.models.dto.UserWithRolDto;
import com.sistemaGestionUsuarios.models.dto.UsuarioDto;
import com.sistemaGestionUsuarios.models.entity.Cargo;
import com.sistemaGestionUsuarios.models.entity.Direccion;
import com.sistemaGestionUsuarios.models.entity.Usuario;
import com.sistemaGestionUsuarios.service.UsuarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioImplement implements UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UsuarioDto> findAll() {
        String query = "select u from Usuario u";
        List<Usuario> usuarioList = entityManager.createQuery(query).getResultList();

        List<UsuarioDto> usuarioDtoList = new ArrayList<>();
        for (Usuario usu: usuarioList) {
            String nombreCompleto = usu.getNombre() + " " + usu.getApellido();
            String direccion = usu.getDireccion() != null ? usu.getDireccion().getPais() + ", " + usu.getDireccion().getCiudad() : "";
            String cargo = usu.getCargo() != null ? usu.getCargo().getCargo() : "";


            usuarioDtoList.add(UsuarioDto.builder()
                            .id(usu.getId())
                            .email(usu.getEmail())
                            .password(usu.getPassword())
                            .telefono(usu.getTelefono())
                            .nombre_completo(nombreCompleto)
                            .direccion(direccion)
                            .cargo(cargo)
                    .build()
            );
        }

        return usuarioDtoList;
    }

    @Override
    @Transactional
    public void save(UserWithRolDto user) {
        //Buscamos rango y direccion existente
        //String query = "select c from Cargo c where id_cargo = :id_cargo";
        Cargo cargoExist = entityManager.find(Cargo.class, user.getCargo_id());
                /*(Cargo) entityManager.createQuery(query)
                .setParameter("id_cargo", user.getCargo_id())
                .getSingleResult();*/

        //String query2 = "select d from Direccion d where id_direccion = :id_direccion";
        Direccion direcExist = entityManager.find(Direccion.class, user.getDireccion_id());
                /*(Direccion) entityManager.createQuery(query2)  //era otra forma de hacerlo
                .setParameter("id_direccion", user.getDireccion_id())
                .getSingleResult();*/

        //datos del nuevo usuario.
        Usuario usuario = Usuario.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .telefono(user.getTelefono())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .direccion(direcExist)
                .cargo(cargoExist)
                .build();

        entityManager.persist(usuario);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    @Transactional
    public boolean update(Integer id, UserWithRolDto user) {
        Usuario usuario = entityManager.find(Usuario.class, id);

        Cargo cargoExist = entityManager.find(Cargo.class, user.getCargo_id());
        Direccion direcExist = entityManager.find(Direccion.class, user.getDireccion_id());

        //actualizamos
        if (usuario != null){
            usuario.setEmail(user.getEmail());
            usuario.setPassword(user.getPassword());
            usuario.setTelefono(user.getTelefono());
            usuario.setNombre(user.getNombre());
            usuario.setApellido(user.getApellido());
            usuario.setDireccion(direcExist);
            usuario.setCargo(cargoExist);

            entityManager.merge(usuario);
            return true;
        } else {
            return false;
        }


    }
}
