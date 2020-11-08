package br.com.aula.tarefas.controller;

import java.sql.Connection;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.aula.tarefas.dao.UsuarioDao;
import br.com.aula.tarefas.jdbc.ConnectionFactory;
import br.com.aula.tarefas.modelo.Usuario;

@Controller
public class LoginController{
	private Connection conn;
	
	public LoginController() {
		this.conn = new ConnectionFactory().getConnection();
	}

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login/formulario-login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if(new UsuarioDao(conn).existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("menu")
	public String menu(Usuario usuario, HttpSession session) {
		return "menu";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
	return "redirect:loginForm";
	}
}