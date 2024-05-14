package org.serratec.projetogrupo1.services;

import org.serratec.projetogrupo1.entities.Perfil;
import org.serratec.projetogrupo1.entities.Usuario;
import org.serratec.projetogrupo1.repositories.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    @Autowired
    PerfilRepository perfilRepository;
    public List<Perfil> findAll(){
        return perfilRepository.findAll();
    }

    public Perfil findById(Integer id){
        return perfilRepository.findById(id).orElse(null);
    }

    public Perfil save(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    public Perfil update(Perfil perfil){
        return perfilRepository.save(perfil);
    }

    /*public String delete(Integer id){
        if(perfilRepository.existsById(id) == true) {
         Perfil excluir = perfilRepository.findById(id).orElse(null);
            try{
                perfilRepository.deleteById(id);
                return excluir.toString()+ "\nDELETADO COM SUCESSO";
            }catch (Exception e){
                System.out.println(e);
                return "ERRO AO EXCLUIR";
            }
        return "PERFIL NAO ENCONTRADO!";
    }*/

    public Perfil delete(Integer id){
        if(perfilRepository.existsById(id) == true) {
            Perfil excluir = perfilRepository.findById(id).orElse(null);
            try {
                perfilRepository.deleteById(id);
                return excluir;
            }catch (Exception e){
                System.out.println(e);
                return  null;
            }
        }
        return null;
    }

    public List<Usuario> findUsuarioByPerfilId(Integer id){
        Optional<Perfil> perfil = perfilRepository.findById(id);
        return perfil.get().getUsuarios();
    }

    public long count (){
        return perfilRepository.count();
    }
}
