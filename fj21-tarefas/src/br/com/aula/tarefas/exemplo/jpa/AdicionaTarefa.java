package br.com.aula.tarefas.exemplo.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aula.tarefas.modelo.Tarefa5;

public class AdicionaTarefa {
	public static void main(String[] args) {
		
		Tarefa5 tarefa5 = new Tarefa5();
		tarefa5.setDescricao("Estudar JPA e Hibernate");
		tarefa5.setFinalizado(true);
		tarefa5.setDataFinalizacao(LocalDate.now().toString());
		
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(tarefa5);
		manager.getTransaction().commit();
		
		System.out.println("ID da tarefa: " + tarefa5.getId());
		manager.close();
	}
}