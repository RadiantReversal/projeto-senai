package com.senai.projetosenai.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Escola {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String nome;
    // novas alterações

    @Column(nullable = false)
    private String endereço;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String diretor;


    @JsonManagedReference
    @OneToMany(mappedBy = "escola")
    private Set<Aluno> alunos;

    public Escola () {}

    public Escola(Integer id, String nome, String endereço, String telefone, String email, String diretor, Set<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.alunos = alunos;
        this.endereço = endereço;
        this.telefone = telefone;
        this.email = email;
        this.diretor = diretor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
