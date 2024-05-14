package org.serratec.projetogrupo1.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editora")
public class Editora {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editora_id")
	 private Integer editoraId;
	
	@Column(name = "nome")
    private String nome;
	
    @Column(name = "imagem_nome")
    private String imagem_nome;
    
    @Column(name = "imagem_filename")
    private String imagem_filename;
	
    @Column(name = "imagem_url")
    private String imagem_url;
    
    @OneToMany(mappedBy = "editora")
    @JsonIgnore
    private List<Livro> livros;

	public Editora(Integer editoraId, String nome, String imagem_nome, String imagem_filename, String imagem_url,
			List<Livro> livros) {
		
		this.editoraId = editoraId;
		this.nome = nome;
		this.imagem_nome = imagem_nome;
		this.imagem_filename = imagem_filename;
		this.imagem_url = imagem_url;
		this.livros = livros;
	}

	public Editora() {
		super();
	}

	public Integer getEditoraId() {
		return editoraId;
	}

	public void setEditoraId(Integer editoraId) {
		this.editoraId = editoraId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem_nome() {
		return imagem_nome;
	}

	public void setImagem_nome(String imagem_nome) {
		this.imagem_nome = imagem_nome;
	}

	public String getImagem_filename() {
		return imagem_filename;
	}

	public void setImagem_filename(String imagem_filename) {
		this.imagem_filename = imagem_filename;
	}

	public String getImagem_url() {
		return imagem_url;
	}

	public void setImagem_url(String imagem_url) {
		this.imagem_url = imagem_url;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

    
	
}




