package br.com.aula.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.aula.mvc.logica.Logica;

/**
 * Servlet implementation class ControllerServlet
 * @param <T>
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException {
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.aula.mvc.logica." + parametro;
		try {
			//Use Class<?>se a classe que está sendo modelada for desconhecida.
			//forName carrega e inicia um objeto da classe cujo nome é passado como parâmetro
			//https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();
			String pagina = logica.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}

}
