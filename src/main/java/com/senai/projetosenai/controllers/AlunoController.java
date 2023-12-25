package com.senai.projetosenai.controllers;

import java.util.List;

import com.senai.projetosenai.dtos.AlunoDetailsDTO;
import com.senai.projetosenai.dtos.EscolaDTO;
import com.senai.projetosenai.entities.Escola;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.senai.projetosenai.entities.Aluno;
import com.senai.projetosenai.services.AlunoService;


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
    public AlunoDetailsDTO buscarDetalhesAluno(@PathVariable Integer id) {
        Aluno aluno = service.buscarId(id);

        AlunoDetailsDTO alunoDTO = convertToDTO(aluno);

        return alunoDTO;
    }

    private AlunoDetailsDTO convertToDTO(Aluno aluno) {
        AlunoDetailsDTO alunoDTO = new AlunoDetailsDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setEndereco(aluno.getEndereco());
        alunoDTO.setEmail(aluno.getEmail());
        alunoDTO.setTelefone(aluno.getTelefone());
        alunoDTO.setDataNascimento(aluno.getDataNascimento());
        alunoDTO.setGenero(aluno.getGenero());

        EscolaDTO escolaDTO = new EscolaDTO();
        Escola escola = aluno.getEscola();
        if (escola != null) {
            escolaDTO.setId(escola.getId());
            escolaDTO.setNome(escola.getNome());
        }

        alunoDTO.setEscola(escolaDTO);

        return alunoDTO;
    }

    @PostMapping
    public ResponseEntity<String> saveAluno(@RequestBody Aluno aluno) {
        service.saveAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body("Aluno cadastrado com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> editarAluno(@PathVariable Integer id, @RequestBody Aluno aluno) {
    String response = service.editarAluno(id, aluno);
    return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirAluno(@PathVariable Integer id) {
    service.excluirAluno(id);
    return ResponseEntity.ok("Aluno excluído com sucesso.");
    }
}
