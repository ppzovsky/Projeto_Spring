package org.serratec.projetogrupo1.services;

import java.util.List;

import org.serratec.projetogrupo1.entities.Livro;
import org.serratec.projetogrupo1.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	@Autowired
    LivroRepository livroRepository;
    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById(Integer id){
        return livroRepository.findById(id).orElse(null);
    }

    public Livro save(Livro perfil){
        return livroRepository.save(perfil);
    }

    public Livro update(Livro perfil){
        return livroRepository.save(perfil);
    }

    public Livro delete(Integer id){
        if(livroRepository.existsById(id) == true) {
        	Livro excluir = livroRepository.findById(id).orElse(null);
            try {
            	livroRepository.deleteById(id);
                return excluir;
            }catch (Exception e){
                System.out.println(e);
                return  null;
            }
        }
        return null;
    }
//
//    public List<Emprestimo> findByPerfil(Integer id){
//        Optional<Livro> perfil = livroRepository.findById(id);
//        return perfil.get().getEmprestimo();
//    }

    public long count (){
        return livroRepository.count();
    }
}
