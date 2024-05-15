package org.serratec.projetogrupo1.services;

import java.util.List;
import java.util.Optional;

import org.serratec.projetogrupo1.entities.Aluno;
import org.serratec.projetogrupo1.entities.Emprestimo;
import org.serratec.projetogrupo1.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	public Aluno findById(Integer id) {
		return alunoRepository.findById(id).orElse(null);
	}

	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno update(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	public Aluno delete(Integer id) {
		if (alunoRepository.existsById(id) == true) {
			Aluno excluir = alunoRepository.findById(id).orElse(null);
			try {
				alunoRepository.deleteById(id);
				return excluir;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		return null;
	}
	public List<Emprestimo> findEmprestimoByAlunoId(Integer id){
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.get().getEmprestimos();
	}
}
