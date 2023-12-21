package com.senai.projetosenai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senai.projetosenai.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
