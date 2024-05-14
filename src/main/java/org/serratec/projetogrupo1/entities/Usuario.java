package org.serratec.projetogrupo1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.serratec.projetogrupo1.entities.Perfil;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_nome")
    private String nome;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String senha;
    @ManyToOne
    @JoinColumn(name="perfil_id")
    @JsonIgnore
    private Perfil perfil;

    public Usuario(Integer userId, String nome, String email, String senha) {
        this.userId = userId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil.getNome();
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
