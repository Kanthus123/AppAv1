<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelo.Filmes" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<div align="center">
			<table border="1" cellpadding="2" cellspacing="0">
				<tr>
					<th>TITULO</th>
					<th>AUTOR</th>
					<th>ID</th>
					<th>PRECO</th>
					<th>ANO</th>
					<th>GENERO</th>
					<th>Exclusao</th>
				</tr>
			<% 
				List<Filmes> listaFilmes = (List<Filmes>)request.getAttribute("lista");
				for(Iterator i = listaFilmes.iterator(); i.hasNext();) {
					Filmes filmes = (Filmes)i.next();
					
			%>
				<tr>
					<td>
					
					<%= filmes.getTitulo() %>		
			
					</td>
					
					<td>
					
					<%= filmes.getAutor() %>		
			
					</td>
					
					<td>
					
					<%= filmes.getId() %>		
			
					</td>
					
					<td>
					
						<%= filmes.getPreco() %>
						
					</td>
					<td>
					
						<%= filmes.getAno() %>	
					</td>
						
					<td>
					
					<%= filmes.getGenero() %>		
			
					</td>
				</tr>
				<%
				
						}
				
				%>
						
			</table>
			
		
		</div>

	<a href="index.jsp">Inicio</a>
</body>
</html>