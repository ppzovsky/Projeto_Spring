package org.serratec.projetogrupo1.repositories;

import org.serratec.projetogrupo1.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
