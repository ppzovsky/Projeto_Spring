package org.serratec.projetogrupo1.controller;

import org.serratec.projetogrupo1.entities.Emprestimo;
import org.serratec.projetogrupo1.entities.Livro;
import org.serratec.projetogrupo1.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/emprestimo")
public class EmprestimoController {
    @Autowired
    EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<Emprestimo>> findAll() {
        return new ResponseEntity<>(emprestimoService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Integer id){
        Emprestimo emprestimo = emprestimoService.findById(id);
        if (emprestimo == null){
            return new ResponseEntity<>(emprestimo, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Emprestimo> save(@RequestBody Emprestimo emprestimo) {
        return new ResponseEntity<>(emprestimoService.save(emprestimo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Emprestimo> update(@RequestBody Emprestimo emprestimo) {
        return new ResponseEntity<>(emprestimoService.update(emprestimo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Emprestimo> delete(@PathVariable Integer id) {
        Emprestimo emprestimo = emprestimoService.findById(id);
        if (emprestimo == null){
            return new ResponseEntity<>(emprestimo, HttpStatus.NOT_FOUND);
        }
        else {
            emprestimoService.delete(id);
            return new ResponseEntity<>(emprestimo, HttpStatus.OK);
        }
    }
   
    
    @GetMapping("/livros-disponiveis")
    public ResponseEntity<List<Livro>> findAllDisponiveis() {
        return new ResponseEntity<>(emprestimoService.findAllDisponiveis(), HttpStatus.OK);
    }
}
