package com.gerenciartarefas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "ItemExecucao")

public class ItemExecucao {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long codigo;

	@Column(name = "percentual")

	private double percentual;

	@Column(name = "descricao")

	private String descricao;

	@Column(name = "dataExecucao")

	private String dataExecucao;
	

	public Long getCodigo() {

		return codigo;

	}

	public void setCodigo(Long codigo) {

		this.codigo = codigo;

	}

	public double getPercentual() {

		return percentual;

	}

	public void setPercentual(double percentual) {

		this.percentual = percentual;

	}

	public String getDescricao() {

		return descricao;

	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;

	}

	public String getDataExecucao() {

		return dataExecucao;

	}

	public void setDataExecucao(String dataExecucao) { 

		this.dataExecucao = dataExecucao; 

	}
	
}
