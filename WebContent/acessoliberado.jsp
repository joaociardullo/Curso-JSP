<jsp:useBean id="calcula" class="beans.BeanCursoJsp"
	type="beans.BeanCursoJsp" scope="page" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>





<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty property="*" name="calcula" />
	<h3>Seja Bem Vindo ao Sitema em JSP</h3>

	<a href="salvarUsuario?acao=listartodos" title="Cadastro de Usuarios"><img src="resources/img/usuario.png" target="_self"></a>
</body>
</html>