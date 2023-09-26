package com.gerenciartarefas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciartarefas.entities.ItemExecucao;
import com.gerenciartarefas.repository.ItemExecucaoRepository;

@Service
public class ItemExecucaoService {

	private final ItemExecucaoRepository itemExecucaoRepository;

	@Autowired
	public ItemExecucaoService(ItemExecucaoRepository itemExecucaoRepository) {
		this.itemExecucaoRepository = itemExecucaoRepository;
	}

	public List<ItemExecucao> buscaTodosItemExecucao() {
		return itemExecucaoRepository.findAll();
	}

	public ItemExecucao buscaItemExecucaoPeloCodigo(Long id) {
		Optional<ItemExecucao> itemExecucao = itemExecucaoRepository.findById(id);
		return itemExecucao.orElse(null);
	}

	public ItemExecucao salvaItemExecucao(ItemExecucao itemExecucao) {
		return itemExecucaoRepository.save(itemExecucao);
	}

	public ItemExecucao alterarItemExecucao(Long codigo, ItemExecucao alterarItemExecucao) {
		Optional<ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(codigo);
		if (existeItemExecucao.isPresent()) {
			alterarItemExecucao.setCodigo(codigo);
			return itemExecucaoRepository.save(alterarItemExecucao);
		}
		return null;
	}

	public boolean apagarItemExecucao(Long codigo) {
		Optional<ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(codigo);
		if (existeItemExecucao.isPresent()) {
			itemExecucaoRepository.deleteById(codigo);
			return true;
		}
		return false;
	}
}
