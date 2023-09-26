package com.gerenciartarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciartarefas.entities.ItemExecucao;

public interface ItemExecucaoRepository extends JpaRepository<ItemExecucao, Long>  {
	
}


