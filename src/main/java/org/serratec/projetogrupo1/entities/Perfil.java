package org.serratec.projetogrupo1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perfil_id")
    private Integer perfilId;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(mappedBy = "perfil")
    @JsonIgnore
    private List<Usuario> usuarios;

    public Perfil(Integer perfilId, String nome, String descricao) {
        this.perfilId = perfilId;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Perfil() {
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getPerfilId() {
        return perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this.perfilId = perfilId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "\nperfilId= " + perfilId +
                "\nnome= " + nome +
                "\ndescricao= " + descricao +
                '}';
    }

}
