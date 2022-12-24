/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personas.controllers;

import com.personas.models.Usuario;
import com.personas.services.UsuarioService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aguir
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping()
    public ArrayList<Usuario> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    
    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario usaurio){
        return usuarioService.guardarUsuario(usaurio);
    }
    
    @GetMapping(path = "/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return usuarioService.obtenerPorId(id);
    }
    
    @GetMapping("/query")
    public ArrayList<Usuario> obtenerUsuariosPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return usuarioService.obtenerPorPrioridad(prioridad);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se eliminó el usuario con el id " + id;
        } else {
            return "No se pudo eliminar el usuario con el id " + id;
        }
    }
    
    
}
