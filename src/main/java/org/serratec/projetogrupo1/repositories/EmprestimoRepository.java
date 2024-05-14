package org.serratec.projetogrupo1.repositories;

import org.serratec.projetogrupo1.entities.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
