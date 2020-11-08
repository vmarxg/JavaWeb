package br.com.aula.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.aula.modelo.Contato;

public class ContatoDao2 implements GenericDao {
	private Connection connection;

	public ContatoDao2(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void adiciona(Object obj) {
		if (!(obj instanceof Contato)) {
			return;
		}
		Contato contato = (Contato) obj;
		String sql = "INSERT INTO contatos "
				+ "(nome,email,endereco,dataNascimento) " + "VALUES (?,?,?,?)";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<>();

			PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = montaContatoComResultSet(rs);
				contatos.add(contato);
			}
			return contatos;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public Contato pesquisa(long id) {
		PreparedStatement stmt;
		try {
			stmt = this.connection
					.prepareStatement("SELECT * FROM Contatos WHERE id == ?");

			ResultSet rs = stmt.executeQuery();
			stmt.close();

			if (rs.next()) {
				Contato contato = montaContatoComResultSet(rs);
				return contato;
			} else {
				return null;
			}
		} catch (SQLTimeoutException e) {
			throw new DAOException(e);
		} catch (SQLException e) {
			// Conexão com o BD fechada, reabrir e tentar novamente
			throw new DAOException(e);
		}
	}

	@Override
	public void altera(Object obj) {
		if (!(obj instanceof Contato)) {
			return;
		}
		Contato contato = (Contato) obj;

		String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? where id=?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove(Object obj) {
		if (!(obj instanceof Contato)) {
			return;
		}
		Contato contato = (Contato) obj;
		try {
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM contatos WHERE id=?");
			stmt.setLong(1, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Contato montaContatoComResultSet(ResultSet rs) {
		try {
			Contato contato = new Contato();

			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));

			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(rs.getDate("dataNascimento"));
			contato.setDataNascimento(dataNascimento);

			return contato;
		} catch (SQLException e) {
			// Tentou acessar um campo que não existe na tabela
			throw new DAOException(e);
		}
	}
}