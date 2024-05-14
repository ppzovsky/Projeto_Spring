package org.serratec.projetogrupo1.repositories;

import org.serratec.projetogrupo1.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository
        extends JpaRepository<Livro, Integer>{
	
}
