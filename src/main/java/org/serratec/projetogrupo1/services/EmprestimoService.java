package org.serratec.projetogrupo1.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.projetogrupo1.entities.Emprestimo;
import org.serratec.projetogrupo1.entities.Livro;
import org.serratec.projetogrupo1.repositories.EmprestimoRepository;
import org.serratec.projetogrupo1.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {
	@Autowired
	EmprestimoRepository emprestimoRepository;

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	LivroService livroService;

	public List<Emprestimo> findAll() {
		return emprestimoRepository.findAll();
	}

	public Emprestimo findById(Integer id) {
		return emprestimoRepository.findById(id).get();
	}

	public Emprestimo save(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo update(Emprestimo emprestimo) {
		return emprestimoRepository.save(emprestimo);
	}

	public Emprestimo delete(Integer id) {
		if (emprestimoRepository.existsById(id) == true) {
			Emprestimo excluir = emprestimoRepository.findById(id).orElse(null);
			try {
				emprestimoRepository.deleteById(id);
				return excluir;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		return null;
	}

	public List<Livro> findAllDisponiveis() {

		List<Livro> LivrosDisponiveis = new ArrayList<>();
		List<Livro> Livros = livroRepository.findAll();

		for (Livro livro : Livros) {
			if (livro.getEmprestimos() == null) {
				LivrosDisponiveis.add(livro);
			} else {
				List<Emprestimo> Emprestimos = livroService.findEmprestimoByLivroId(livro.getLivroId());
				boolean disponivel = true;

				for (Emprestimo emprestimo : Emprestimos) {
					if (emprestimo.getDataDevolucao().isAfter(LocalDate.now())) {
						disponivel = false;
					}
				}

				if (disponivel == true) {
					LivrosDisponiveis.add(livro);
				}
			}
		}
		return LivrosDisponiveis;

	}
}
