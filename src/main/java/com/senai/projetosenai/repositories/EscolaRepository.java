package com.senai.projetosenai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.projetosenai.entities.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer> {

}
