package org.serratec.projetogrupo1.controller;

import java.util.List;

import org.serratec.projetogrupo1.entities.Livro;
import org.serratec.projetogrupo1.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/livro")
public class LivroController {
    @Autowired
    LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return new ResponseEntity<>(livroService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id){
        Livro livro = livroService.findById(id);
        if (livro == null){
            return new ResponseEntity<>(livro, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(livro, HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        return new ResponseEntity<>(livroService.save(livro), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Livro> update(@RequestBody Livro livro) {
        return new ResponseEntity<>(livroService.update(livro), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> delete(@PathVariable Integer id) {
        Livro livro = livroService.findById(id);
        if (livro == null){
            return new ResponseEntity<>(livro, HttpStatus.NOT_FOUND);
        }
        else {
        	livroService.delete(id);
            return new ResponseEntity<>(livro, HttpStatus.OK);
        }
    }

//    @GetMapping("/{id}/{listusers}")
//    public ResponseEntity<List<Emprestimo>> findByPerfil(@PathVariable Integer id){
//        return new ResponseEntity<>(livroService.findByPerfil(id), HttpStatus.OK);
//    }
}