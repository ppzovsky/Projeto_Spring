package org.serratec.projetogrupo1.controller;

import org.serratec.projetogrupo1.services.UsuarioService;
import org.serratec.projetogrupo1.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id){
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null){
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.update(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null){
            return new ResponseEntity<>(usuario, HttpStatus.NOT_FOUND);
        }
        else {
            usuarioService.delete(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
    }
}
