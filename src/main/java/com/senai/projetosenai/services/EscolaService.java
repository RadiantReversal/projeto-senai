package com.senai.projetosenai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.projetosenai.entities.Escola;
import com.senai.projetosenai.exceptions.NaoEncontrado;
import com.senai.projetosenai.repositories.EscolaRepository;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository repository;

    public List<Escola> getAll() {
        return repository.findAll();
    }

    public Escola buscarId(Integer id) {
        return repository.findById(id).orElseThrow(() -> new NaoEncontrado("Escola não encontrada."));
    }

    public void saveEscola(Escola escola) {
        repository.save(escola);
    }

    public String editarEscola(Integer id, Escola escola) {
        Escola response = repository.findById(id).get();

        response.setNome(escola.getNome());
        repository.save(response);
        return "Escola editada com sucesso!";
    }

    public void excluirEscola(Integer id) {
        Escola response = repository.findById(id).get();
        repository.delete(response);
    }
}

