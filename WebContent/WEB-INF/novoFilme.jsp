<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Filme</title>
</head>
<body>

	<div align="right" 
	style="width: 300px; padding-left: 50px; padding-top: 100px;">
		<p align="center"> Cadastro de Filme</p>
		<form action="InserirFilmesServlet" method="post">
			<fieldset>
				<label>Id :</label>
				<input type="text" name="id" />
				<br />
				<label>Titulo :</label>
				<input type="text" name="titulo" />
				<br />
				<label>Autor :</label>
				<input type="text" name="autor" />
				<br />
				<label>Preco :</label>
				<input type="text" name="preco" />
				<br />
				<label>Ano :</label>
				<input type="text" name="ano" />
				<br />
				<label>Genero :</label>
				<input type="text" name="genero" />
				<br />
				<input type="submit" value="Salvar" />
				<br />
				<label><%=request.getParameter("msg") %></label>
			</fieldset>
		</form>
	
	</div>

</body>
</html>