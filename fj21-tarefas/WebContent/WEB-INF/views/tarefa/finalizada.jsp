<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<td>${tarefa.id}</td>
<td>${tarefa.descricao}</td>
<td>Finalizada</td>
<td>
	<fmt:parseDate value="${tarefa.dataFinalizacao}" type="date"
		pattern="yyyy-MM-dd" var="parsedDate" /> 
	<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" />
</td>
<td><a href="mostraTarefa5?id=${tarefa.id }">Alterar</a></td>
<td><a href="removeTarefa5?id=${tarefa.id }">Remover</a></td>