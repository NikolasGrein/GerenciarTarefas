package com.gerenciartarefas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "GerenciarTarefas")

public class GerenciarTarefas {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long codigo;

	@Column(name = "nome")

	private String nome;

	@Column(name = "dataLimiteExecucao")

	private String dataLimiteExecucao;

	@Column(name = "detalhesTarefa")

	private String detalhesTarefa;
	
	@Column(name = "statusTarefa")

	private String statusTarefa;

	public Long getCodigo() {

		return codigo;

	}

	public void setCodigo(Long codigo) {

		this.codigo = codigo;

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

	}

	public String getDataLimiteExecucao() {

		return dataLimiteExecucao;

	}

	public void setDataLimiteExecucao(String dataLimiteExecucao) {

		this.dataLimiteExecucao = dataLimiteExecucao;

	}

	public String getDetalhesTarefa() {

		return detalhesTarefa;

	}

	public void setDetalhesTarefa(String detalhesTarefa) { 

		this.detalhesTarefa = detalhesTarefa; 

	}
	
	public String getStatusTarefa() {

		return statusTarefa;

	}

	public void setStatusTarefa(String statusTarefa) { 

		this.statusTarefa = statusTarefa; 

	}
}
