package br.com.aula.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aula.tarefas.dao.TarefaDAO;
import br.com.aula.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	//Mágica! Nem precisamos fazer nada para criar o objeto tarefa. 
	//O framework já faz isso para nós. Agora é só mandar persistir no banco.
//	@RequestMapping("adicionaTarefa")
//	public String adiciona(Tarefa tarefa) {
//		TarefaDAO dao = new TarefaDAO();
//		dao.adiciona(tarefa);
//		return "tarefa/adicionada";
//	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if(result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		TarefaDAO dao = new TarefaDAO();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	//Mágica! Para mandar a lista de objetos tarefas basta utiliza Model and View como parâmetro. 
	//O framework já faz isso para nós. Agora é só mandar persistir no banco.
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/lista";
	}
	
/*Outra forma de fazer instanciando Model and View explicitamente*/
//	@RequestMapping("listaTarefas")
//	public ModelAndView lista() {
//		TarefaDAO dao = new TarefaDAO();
//		List<Tarefa> tarefas = dao.lista();
//		ModelAndView mv = new ModelAndView("tarefa/lista");
//		mv.addObject("tarefas", tarefas);
//		return mv;
//	}
	
}
