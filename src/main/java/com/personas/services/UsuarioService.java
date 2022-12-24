/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personas.services;

import com.personas.models.Usuario;
import com.personas.repositories.UsuarioRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author aguir
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public ArrayList<Usuario> obtenerUsuarios(){
        return (ArrayList<Usuario>) usuarioRepository.findAll();
    }
    
    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public Optional<Usuario> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    
    public ArrayList<Usuario> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }
    
    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
