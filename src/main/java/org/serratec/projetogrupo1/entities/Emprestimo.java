package org.serratec.projetogrupo1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emprestimo_id")
    private int idEmprestimo;
    @ManyToOne
    @JoinColumn (name = "aluno_matricula")
    private Aluno alunoMatricula;
    @ManyToOne
    @JoinColumn (name = "livro_id")
    private Livro livroId;
    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;
    @Column(name = "data_entrega")
    private LocalDate dataDevolucao;
    @Column(name = "valor_emprestimo")
    private double valorEmprestimo;

    public Emprestimo(int idEmprestimo, Aluno alunoMatricula, Livro livroId, LocalDate dataEmprestimo, LocalDate dataDevolucao, double valorEmprestimo) {
        this.idEmprestimo = idEmprestimo;
        this.alunoMatricula = alunoMatricula;
        this.livroId = livroId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.valorEmprestimo = valorEmprestimo;
    }
    public Emprestimo() {
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Aluno getAlunoMatricula() {
        return alunoMatricula;
    }

    public void setAlunoMatricula(Aluno alunoMatricula) {
        this.alunoMatricula = alunoMatricula;
    }

    public Livro getLivroId() {
        return livroId;
    }

    public void setLivroId(Livro livroId) {
        this.livroId = livroId;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

}