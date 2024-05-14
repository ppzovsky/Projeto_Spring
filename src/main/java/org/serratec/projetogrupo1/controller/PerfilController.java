package org.serratec.projetogrupo1.controller;

import org.serratec.projetogrupo1.services.PerfilService;
import org.serratec.projetogrupo1.entities.Perfil;
import org.serratec.projetogrupo1.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/perfil")
public class PerfilController {
    @Autowired
    PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<Perfil>> resgataPerfis() {
        return new ResponseEntity<>(perfilService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Perfil> findById(@PathVariable Integer id){
        Perfil perfil = perfilService.findById(id);
        if (perfil == null){
            return new ResponseEntity<>(perfil, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(perfil, HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Perfil> criaPerfil(@RequestBody Perfil perfil) {
        return new ResponseEntity<>(perfilService.save(perfil), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Perfil> update(@RequestBody Perfil perfil) {
        return new ResponseEntity<>(perfilService.update(perfil), HttpStatus.OK);
    }

    /*@DeleteMapping("/{id}")  retorna uma string de aviso
    public ResponseEntity<String> deletaPerfil(@PathVariable Integer id) {
        return new ResponseEntity<>(perfilService.delete(id), HttpStatus.OK);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Perfil> deletaPerfil(@PathVariable Integer id) {
        Perfil perfil = perfilService.findById(id);
        if (perfil == null){
            return new ResponseEntity<>(perfil, HttpStatus.NOT_FOUND);
        }
        else {
            perfilService.delete(id);
            return new ResponseEntity<>(perfil, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}/{listusers}")
    public ResponseEntity<List<Usuario>> findUsuarioByPerfilId(@PathVariable Integer id){
        return new ResponseEntity<>(perfilService.findUsuarioByPerfilId(id), HttpStatus.OK);
    }
}
