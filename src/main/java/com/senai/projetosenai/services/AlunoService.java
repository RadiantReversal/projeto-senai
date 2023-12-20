package com.senai.projetosenai.services;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.senai.projetosenai.entities.Aluno;
import com.senai.projetosenai.exceptions.NaoEncontrado;
import com.senai.projetosenai.repositories.AlunoRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public List<Aluno> getAll() {
        return repository.findAll();
    }

    public Aluno buscarId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NaoEncontrado("Aluno não encontrado."));
    }

    public void saveAluno(Aluno aluno) {
        repository.save(aluno);
    }

    public String editarAluno(Integer id, Aluno aluno) {
        Aluno response = repository.findById(id).get();

        response.setNome(aluno.getNome());
        repository.save(response);
        return "Aluno editado com sucesso!";
    }

    public void excluirAluno(Integer id) {
        Aluno response = repository.findById(id).get();
        repository.delete(response);
    }


}
