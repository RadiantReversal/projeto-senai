package com.senai.projetosenai.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping(value = "/{id}")
    public Escola buscarId(@PathVariable Integer id) {
        Escola response = service.buscarId(id);
        return response;
    }

    @PostMapping
    public ResponseEntity<String> saveEscola(@RequestBody Escola escola) {
        service.saveEscola(escola);
        return ResponseEntity.status(HttpStatus.CREATED).body("Escola cadastrada com sucesso!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> editarEscola(@PathVariable Integer id, @RequestBody Escola escola) {
    String response = service.editarEscola(id, escola);
    return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirEscola(@PathVariable Integer id) {
    service.excluirEscola(id);
    return ResponseEntity.ok("Escola excluída com sucesso.");
    }

}
