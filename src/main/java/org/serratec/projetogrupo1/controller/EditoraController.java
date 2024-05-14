package org.serratec.projetogrupo1.controller;

import java.util.List;

import org.serratec.projetogrupo1.entities.Editora;
import org.serratec.projetogrupo1.services.EditoraService;
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
@RequestMapping ("/editora")
public class EditoraController {
	@Autowired
    EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<Editora>> resgataPerfis() {
        return new ResponseEntity<>(editoraService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Integer id){
        Editora editora = editoraService.findById(id);
        if (editora == null){
            return new ResponseEntity<>(editora, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(editora, HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Editora> criaPerfil(@RequestBody Editora editora) {
        return new ResponseEntity<>(editoraService.save(editora), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Editora> update(@RequestBody Editora editora) {
        return new ResponseEntity<>(editoraService.update(editora), HttpStatus.OK);
    }

    /*@DeleteMapping("/{id}")  retorna uma string de aviso
    public ResponseEntity<String> deletaPerfil(@PathVariable Integer id) {
        return new ResponseEntity<>(perfilService.delete(id), HttpStatus.OK);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Editora> deletaPerfil(@PathVariable Integer id) {
    	Editora editora = editoraService.findById(id);
        if (editora == null){
            return new ResponseEntity<>(editora, HttpStatus.NOT_FOUND);
        }
        else {
        	editoraService.delete(id);
            return new ResponseEntity<>(editora, HttpStatus.OK);
        }
    }

//    @GetMapping("/{id}/{listusers}")
//    public ResponseEntity<List<Livro>> findUsuarioByPerfilId(@PathVariable Integer id){
//        return new ResponseEntity<>(editoraService.findUsuarioByPerfilId(id), HttpStatus.OK);
//    }
}
