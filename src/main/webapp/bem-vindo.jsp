<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/livros?acao=PaginaInicial" var="menu" />

<!DOCTYPE html>
<html>
<body>

	<h1>Bem vindo ao letra digital</h1>


	<form action="${menu}" method="post">
		<button type="submit" name="button" value="Biblioteca">Biblioteca</button>
		<button type="submit" name="button" value="Novo livro">Novo
			livro</button>
	</form>




</body>
</html>