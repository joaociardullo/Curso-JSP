<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;"
	charset="ISO-8859-1">
<title>Principal</title>
<link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>

	<div class="login-page">
		<div class="form">
			<form action="LoginServlet" method="post" class="login-form">
				Login: <input type="text" id="login" name="login"> <br />
				Senha: <input type="password" id=" senha" name="senha"> <br />
				<button type="submit" value="Logar" onclick="clica()">Logar</button>

			</form>
		</div>
	</div>
<body />
</html>

