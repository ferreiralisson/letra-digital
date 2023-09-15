<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.facol.letra.digital.model.Livro"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/livros?acao=ListarLivroPorId" var="listarLivros" />
<c:url value="/livros?acao=DeletarLivro" var="deletarLivro" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Letra Digital</title>
</head>
<body>

	Listando Livros cadastrados:
	<br />

	<ul>
		<c:forEach items="${livros}" var="livro">
			<li>
				${livro.titulo}
				<a href="${listarLivros}&id=${livro.id}">editar</a>
				<a href="${deletarLivro}&id=${livro.id}">remover</a>
			</li>
		</c:forEach>

	</ul>

</body>
</html>