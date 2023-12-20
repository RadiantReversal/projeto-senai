package com.senai.projetosenai.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senai.projetosenai.entities.Escola;
import com.senai.projetosenai.services.EscolaService;

@RestController
@RequestMapping("/escola")
public class EscolaController {
    @Autowired
    private EscolaService service;

    @GetMapping
    public ResponseEntity<List<Escola>> getAll() {
        List<Escola> lista = service.getAll();
        return ResponseEntity.status(HttpStatus.OK) .body(lista);
    }

    @GetMapping(value = "/{id}")
    public Escola buscarId(@PathVariable Integer id) {
        Escola response = service.buscarId(id);
        return response;
    }

    @PostMapping
    public ResponseEntity<String> saveEscola(@RequestBody  Escola escola) {
    service.saveEscola(escola);
    return ResponseEntity.status(HttpStatus.CREATED).body("Escola cadastrada com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public String editarAluno(@PathVariable Integer id, @RequestBody Escola escola) {
        String response = service.editarEscola(id, escola);
        return response;
    }

    @DeleteMapping(value = "/{id}")
    public String excluirAluno(@PathVariable Integer id) {
        service.excluirEscola(id);
        return "Escola excluída com sucesso!";
    }
}

