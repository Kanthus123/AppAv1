<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, modelo.Cliente" %>
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
					<th>NOME</th>
					<th>CPF</th>
					<th>ENDERECO</th>
					<th>IDADE</th>
					<th>TEL</th>
					<th>Exclusao</th>
				</tr>
			<% 
				List<Cliente> listaCliente = (List<Cliente>)request.getAttribute("lista");
				for(Iterator i = listaCliente.iterator(); i.hasNext();) {
					Cliente cliente = (Cliente)i.next();
					
			%>
				<tr>
					<td>
					
					<%= cliente.getName() %>		
			
					</td>
					<td>
					
						<%= cliente.getCpf() %>
						
					</td>
					<td>
					
						<%= cliente.getIdade() %>	
					</td>	
					<td>
					
						<%= cliente.getTel() %>	
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