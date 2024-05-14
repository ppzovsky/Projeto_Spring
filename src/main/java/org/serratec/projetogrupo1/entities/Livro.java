package org.serratec.projetogrupo1.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "livro")
public class Livro {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livro_id")
	private Integer livroId;
	@Column(name = "nome_livro")
	private String nomeLivro;
	@Column(name = "nome_autor")
	private String nomeAutor;
	@Column(name = "data_lancamento")
	private LocalDate dataLancamento;
	@Column(name = "codigo_isbn")
	private Integer codigoIsbn;
	
	@ManyToOne
    @JoinColumn(name="editora_id")
	@JsonIgnore
    private Editora editora;

	@OneToMany(mappedBy = "livroId")
	private List<Emprestimo> emprestimos;
	
	public Livro() {
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getCodigoIsbn() {
		return codigoIsbn;
	}

	public void setCodigoIsbn(Integer codigoIsbn) {
		this.codigoIsbn = codigoIsbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
}
