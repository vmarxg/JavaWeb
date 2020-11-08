<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto fj21-agenda</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<div class="container">
		<table class="table table-responsive">
			<jsp:useBean id="dao" class="br.com.aula.dao.ContatoDao" />
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Endereço</th>
					<th>Data Nascimento</th>
				</tr>
			</thead>
			<tbody class="table-striped">
				<c:forEach var="contato" items="${dao.lista}" varStatus="id">
					<tr style="background: ${id.count% 2== 0? '#AE8': '#FFF'}">
						<td>${contato.id}</td>
						<td>${contato.nome}</td>
						<!-- Substituindo o uso apenas o IF para o c:choose-->
						<td><c:choose>
								<c:when test="${not empty contato.email}">
									<a href="mailto:${contato.email}">${contato.email}</a>
								</c:when>
								<c:otherwise>E-mail não informado</c:otherwise>
							</c:choose></td>
						<td>${contato.endereco}</td>
						<td><fmt:formatDate value="${contato.dataNascimento.time}"
								pattern="dd/MM/yyyy" /></td>
						<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- fim .container -->
	<c:import url="rodape.jsp" />
</body>
</html>
