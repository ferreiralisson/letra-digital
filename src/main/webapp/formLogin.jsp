<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/livros?acao=Login" var="login"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acesso a biblioteca</title>
</head>
<body>

	<form action="${login}" method="post">
	
		Login: <input type="text" name="login"  /> <br> <br>
		Senha: <input type="password" name="senha">
		<input type="submit" />
	</form>

</body>
</html>