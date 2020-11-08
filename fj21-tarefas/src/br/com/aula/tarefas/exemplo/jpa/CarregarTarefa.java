package br.com.aula.tarefas.exemplo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aula.tarefas.modelo.Tarefa5;

public class CarregarTarefa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa5 encontrada = manager.find(Tarefa5.class, 1L);
		
		System.out.println(encontrada.getDescricao());
		manager.close();

	}

}
