package org.serratec.projetogrupo1.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.projetogrupo1.entities.Emprestimo;
import org.serratec.projetogrupo1.entities.Livro;
import org.serratec.projetogrupo1.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {
    @Autowired
    EmprestimoRepository emprestimoRepository;
    public List<Emprestimo> findAll(){
        return emprestimoRepository.findAll();
    }
    public Emprestimo findById(Integer id){
        return emprestimoRepository.findById(id).orElse(null);
    }

    public Emprestimo save(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo update(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo delete(Integer id){
        if(emprestimoRepository.existsById(id) == true) {
            Emprestimo excluir = emprestimoRepository.findById(id).orElse(null);
            try {
                emprestimoRepository.deleteById(id);
                return excluir;
            }catch (Exception e){
                System.out.println(e);
                return  null;
            }
        }
        return null;
    }
    
 // tentando fazer um método que mostra apenas os livros que estão disponíveis.
    public List<Livro> findAllDisponiveis() {
        List<Emprestimo> Emprestimos = emprestimoRepository.findAll();
        List<Livro> LivrosDisponiveis = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        for (Emprestimo emprestimo : Emprestimos) {
            if (emprestimo.getDataDevolucao().isAfter(hoje)) {
                LivrosDisponiveis.add(emprestimo.getLivroIdEmprestimo());
            }
        }
        return LivrosDisponiveis;
    }
}
