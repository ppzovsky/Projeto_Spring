package org.serratec.projetogrupo1.controller;

import java.util.List;

import org.serratec.projetogrupo1.entities.Aluno;
import org.serratec.projetogrupo1.entities.Emprestimo;
import org.serratec.projetogrupo1.services.AlunoService;
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
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		return new ResponseEntity<>(alunoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
		Aluno aluno = alunoService.findById(id);
		if (aluno == null) {
			return new ResponseEntity<>(aluno, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(aluno, HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<Aluno> save(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.save(aluno), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Aluno> update(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.update(aluno), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> delete(@PathVariable Integer id) {
		Aluno aluno = alunoService.findById(id);
		if (aluno == null) {
			return new ResponseEntity<>(aluno, HttpStatus.NOT_FOUND);
		} else {
			alunoService.delete(id);
			return new ResponseEntity<>(aluno, HttpStatus.OK);
		}
	}

	@GetMapping("/{id}/emprestimos")
	public ResponseEntity<?> findEmprestimoByAlunoId(@PathVariable Integer id){
		Aluno aluno = alunoService.findById(id);
		List<Emprestimo> emprestimos = alunoService.findEmprestimoByAlunoId(id);

		if (aluno == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não registrado!");
		}
		if (emprestimos == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno sem registros de emprestimos!");
		}
		return new ResponseEntity<>(emprestimos, HttpStatus.OK);
	}
}
