package br.com.aula.tarefas.modelo;

import java.time.LocalDateTime;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.aula.tarefas.dao.LocalDateTimeAttributeConverter;

@Entity
public class Tarefa5 {

	@Id
	@GeneratedValue
	private Long id;
	private String descricao;
	private boolean finalizado;
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime dataFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public LocalDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacao(String dataFinalizacao) {
		this.dataFinalizacao = LocalDateTime.parse(dataFinalizacao);
	}

	@Override
	public String toString() {
		return "Tarefa3 [id=" + id + ", descricao=" + descricao + ", finalizado=" + finalizado + ", dataFinalizacao="
				+ dataFinalizacao + "]";
	}
	
}
