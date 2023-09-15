<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/livros?acao=AtualizarLivro" var="atualizarLivro" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualização de livro</title>
</head>
<body>

	<form action="${atualizarLivro}" method="post">
		Titulo: <input type="text" name="titulo" value="${livro.titulo}"/> <br><br> 
		Genero: <input type="text" name="genero" value="${livro.genero}"> <br><br>
		<input type="hidden" name="id" value="${livro.id}" />
		<input type="submit" />
	</form>

</body>
</html>