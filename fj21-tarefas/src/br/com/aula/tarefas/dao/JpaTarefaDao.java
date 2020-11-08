package br.com.aula.tarefas.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.aula.tarefas.modelo.Tarefa5;

@Repository
public class JpaTarefaDao implements TarefaDao5 {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public Tarefa5 buscaPorId(Long id) {
		return manager.find(Tarefa5.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarefa5> lista() {
		return manager.createQuery("select t from Tarefa5 t")
				.getResultList();
	}

	@Override
	public void adiciona(Tarefa5 t) {
		manager.persist(t);

	}

	@Override
	public void altera(Tarefa5 t) {
		manager.merge(t);

	}

	@Override
	public void remove(Tarefa5 t) {
		Tarefa5 tarefaARemover = buscaPorId(t.getId());
		manager.remove(tarefaARemover);

	}

	@Override
	public void finaliza(Long id) {
		Tarefa5 tarefa5 = buscaPorId(id);
		tarefa5.setFinalizado(true);
		tarefa5.setDataFinalizacao(LocalDateTime.now().toString());

	}

}
