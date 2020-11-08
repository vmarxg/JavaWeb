package br.com.aula.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.dao.ContatoDao2;
import br.com.aula.modelo.Contato;

public class ListaContatosLogic2 implements Logica{

	@Override
	public String executa(HttpServletRequest req, 
			HttpServletResponse res) 
					throws Exception {
		List<Contato> contatos = new ContatoDao2((Connection)req.getAttribute("conexao"))
				.getLista();
		req.setAttribute("contatos", contatos);
		return "/WEB-INF/jsp/lista-contatos4.jsp";
	}

}
