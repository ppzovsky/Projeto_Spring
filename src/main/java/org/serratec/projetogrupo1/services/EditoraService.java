package org.serratec.projetogrupo1.services;

import java.util.List;
import org.serratec.projetogrupo1.entities.Editora;
import org.serratec.projetogrupo1.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {
	
	@Autowired
    EditoraRepository editoraRepository;
    public List<Editora> findAll(){
        return editoraRepository.findAll();
    }
    public Editora findById(Integer id){
        return editoraRepository.findById(id).orElse(null);
    }
    
    public Editora save(Editora editora){
        return editoraRepository.save(editora);
    }
    
    public Editora update(Editora editora){
        return editoraRepository.save(editora);
    }

    public Editora delete(Integer id){
        if(editoraRepository.existsById(id) == true) {
            Editora excluir = editoraRepository.findById(id).orElse(null);
            try {
                editoraRepository.deleteById(id);
                return excluir;
            }catch (Exception e){
                System.out.println(e);
                return  null;
            }
        }
        return null;
    }

    public long count (){
        return editoraRepository.count();
    }
}
