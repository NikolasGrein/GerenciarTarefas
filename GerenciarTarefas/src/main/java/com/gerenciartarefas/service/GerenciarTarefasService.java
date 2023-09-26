package com.gerenciartarefas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciartarefas.entities.GerenciarTarefas;
import com.gerenciartarefas.repository.GerenciarTarefasRepository;

@Service
public class GerenciarTarefasService {

	private final GerenciarTarefasRepository gerenciarTarefasRepository;

	@Autowired
	public GerenciarTarefasService(GerenciarTarefasRepository gerenciarTarefasRepository) {
		this.gerenciarTarefasRepository = gerenciarTarefasRepository;
	}

	public List<GerenciarTarefas> buscaTodosGerenciarTarefas() {
		return gerenciarTarefasRepository.findAll();
	}

	public GerenciarTarefas buscaGerenciarTarefasPeloCodigo(Long id) {
		Optional<GerenciarTarefas> gerenciarTarefas = gerenciarTarefasRepository.findById(id);
		return gerenciarTarefas.orElse(null);
	}

	public GerenciarTarefas salvaGerenciarTarefas(GerenciarTarefas gerenciarTarefas) {
		return gerenciarTarefasRepository.save(gerenciarTarefas);
	}

	public GerenciarTarefas alterarGerenciarTarefas(Long codigo, GerenciarTarefas alterarGerenciarTarefas) {
		Optional<GerenciarTarefas> existeGerenciarTarefas = gerenciarTarefasRepository.findById(codigo);
		if (existeGerenciarTarefas.isPresent()) {
			alterarGerenciarTarefas.setCodigo(codigo);
			return gerenciarTarefasRepository.save(alterarGerenciarTarefas);
		}
		return null;
	}

	public boolean apagarGerenciarTarefas(Long codigo) {
		Optional<GerenciarTarefas> existeGerenciarTarefas = gerenciarTarefasRepository.findById(codigo);
		if (existeGerenciarTarefas.isPresent()) {
			gerenciarTarefasRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}
