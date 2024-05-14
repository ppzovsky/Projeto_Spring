package org.serratec.projetogrupo1.services;

import org.serratec.projetogrupo1.entities.Editora;
import org.serratec.projetogrupo1.entities.Emprestimo;
import org.serratec.projetogrupo1.repositories.EditoraRepository;
import org.serratec.projetogrupo1.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
