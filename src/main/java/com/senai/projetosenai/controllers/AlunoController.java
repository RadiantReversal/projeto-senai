package com.senai.projetosenai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senai.projetosenai.entities.Aluno;
import com.senai.projetosenai.services.AlunoService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll() {
        List<Aluno> lista = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public Aluno buscarId(@PathVariable Integer id) {
        Aluno response = service.buscarId(id);
        return response;
    }

    @PostMapping
    public ResponseEntity<String> saveAluno(@RequestBody Aluno aluno) {
        service.saveAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body("Aluno cadastrado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public String editarAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
        String response = service.editarAluno(id, aluno);
        return response;
    }

    @DeleteMapping(value = "/{id}")
    public String excluirAluno(@PathVariable Integer id) {
        service.excluirAluno(id);
        return "Aluno excluído com sucesso!";
    }
}
