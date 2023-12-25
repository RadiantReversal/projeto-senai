package com.senai.projetosenai.dtos;

import java.time.LocalDate;

public class AlunoDetailsDTO {
    private Integer id;
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String genero;
    private EscolaDTO escola;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public EscolaDTO getEscola() {
        return escola;
    }

    public void setEscola(EscolaDTO escola) {
        this.escola = escola;
    }
}

