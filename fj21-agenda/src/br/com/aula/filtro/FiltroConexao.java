package br.com.aula.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.aula.jdbc.ConnectionFactory;

/**
 * Servlet Filter implementation class FiltroConexao
 */
@WebFilter("/*")
public class FiltroConexao implements Filter {

	/**
	 * Default constructor. 
	 */
	public FiltroConexao() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			Connection connection = new ConnectionFactory()
					.getConnection();
			// pendurando a connection na requisição
			request.setAttribute("conexao", connection);
			chain.doFilter(request, response);
			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
