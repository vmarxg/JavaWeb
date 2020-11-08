<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Usando a tag <c:url> ficamos livres para utilizar caminhos absolutos --%>
<c:url value="/imagens/caelum.png" var="imagem"/>
<img src="${imagem}" width="200" height="100"/>

<!-- Outra forma -->
<%-- <img src="<c:url value="/imagens/caelum.png" />" width="200" height="100"/> --%>

<!-- Caminho relativo -->
<!-- <img src="imagens/caelum.png" width="200" height="100"/> -->

<h2>Agenda de Contatos de Tassio Pinheiro</h2>
<hr />