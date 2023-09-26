package com.gerenciartarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciartarefas.entities.GerenciarTarefas;

public interface GerenciarTarefasRepository extends JpaRepository<GerenciarTarefas, Long>  {

}
	