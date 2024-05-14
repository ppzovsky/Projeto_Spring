package org.serratec.projetogrupo1.services;

import org.serratec.projetogrupo1.entities.Usuario;
import org.serratec.projetogrupo1.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario delete(Integer id){
        if(usuarioRepository.existsById(id) == true) {
            Usuario excluir = usuarioRepository.findById(id).orElse(null);
            try {
                usuarioRepository.deleteById(id);
                return excluir;
            }catch (Exception e){
                System.out.println(e);
                return  null;
            }
        }
        return null;
    }

}
