<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto fj21-agenda</title>
</head>
<body>
	<!-- cria o DAO -->
	<jsp:useBean id="dao" class="br.com.aula.dao.ContatoDao" />

	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data Nascimento</th>
			</tr>
		</thead>
		<!-- percorre contatos montando as linhas da tabela -->
		<c:forEach var="contato" items="${dao.lista}">
			<tr>
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento.time}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>