/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personas.repositories;

import com.personas.models.Usuario;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aguir
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
    public abstract ArrayList<Usuario> findByPrioridad(Integer prioridad);
}
