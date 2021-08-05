<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuario</title>

<link rel="stylesheet" href="resources/css/cadastro.css">
</head>
<body>
	<center>
		<h2>Cadastro de Usuario</h2>
	</center>
	
	<h3 style="color:red;">${msg}</h3>

	<form action="salvarUsuario" method="post" id="formUser">
		<table>
			<tr> 
				<td>Codigo:
				<td />
				<td><input type="text" readonly="readonly" id="id" name="id"
					value="${user.id}" class="label-email">
				<td />
			<tr />

			<tr>
				<td>Login:
				<td />
				<td><input type="text" id="login" name="login" class="email"
					class="label-email" value="${user.login}">
				<td />
			<tr />


			<tr>
				<td>Senha:
				<td />
				<td><input type="password" id="senha" name="senha"
					class="required" value="${user.senha}">
				<td />
			<tr />

			<tr>
				<td>Nome:
				<td />
				<td><input type="text" id="nome" name="nome" class="required"
					value="${user.nome}">
				<td />
			<tr />
			<td><input type="submit" value="Salvar"> <input	type="submit" value="Cancelar" onclick="document.getElementById('formUser').action = 'salvarUsuario?acao = reset'"></td>
		</table>



		<table>
			<caption>Usuarios cadastrado</caption>

			<tr>
				<th>ID</th>
				<th>Login</th>
				<th>Nome</th>
				<th>Delete</th>
				<th>Editar</th>
			</tr>

			<c:forEach items="${usuarios}" var="user">
				<tr>
					<td style="width: 150px"><c:out value="${user.id}"></c:out></td>

					<td style="width: 150px"><c:out value="${user.login}"></c:out></td>

					<td><c:out value="${user.nome}"></c:out></td>

					<td><a href="salvarUsuario?acao=delete&user=${user.id}"><img
							src="resources/img/excluir.png" title="Excluir" widht="20px"
							height="20px"></a></td>
					<td><a href="salvarUsuario?acao=editar&user=${user.id}"><img
							src="resources/img/editar.png" title="Editar" width="20px"
							height="20px"></a></td>

				</tr>
			</c:forEach>


		</table>
</body>
</html>