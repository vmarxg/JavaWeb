package br.com.aula.tarefas.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aula.tarefas.dao.TarefaDao5;
import br.com.aula.tarefas.modelo.Tarefa5;

@Transactional
@Controller
public class TarefasController5{
	
	@Autowired
	private TarefaDao5 dao;

	
	@RequestMapping("novaTarefa5")
	public String form() {
		return "tarefa/formulario5";
	}
	
	@RequestMapping("adicionaTarefa5")
	public String adiciona(@Valid Tarefa5 tarefa5, BindingResult result) {
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario5";
		}
		dao.adiciona(tarefa5);
		return "tarefa/adicionada5";
	}
	
	@RequestMapping("listaTarefas5")
	public String lista(Model model) {
		List<Tarefa5> tarefas5 = dao.lista();
		model.addAttribute("tarefas", tarefas5);
		return "tarefa/lista5";
	}

	@RequestMapping("alteraTarefa5")
	public String altera(Tarefa5 tarefa5){
		dao.altera(tarefa5);
		return "redirect:listaTarefas5";
	}
	
	@RequestMapping("mostraTarefa5")
	public String mostra(Long id, Model model) {
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/mostra5";
	}

	@RequestMapping("removeTarefa5")
	public String remove(Tarefa5 tarefa5) {
		dao.remove(tarefa5);
		return "redirect:listaTarefas5";
	}
	
	@RequestMapping("finalizaTarefa5")
	public String finaliza(Long id, Model model) {
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/finalizada5";
	}
}
