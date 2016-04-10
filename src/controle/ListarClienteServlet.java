package controle;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.fabricaConexao;
import modelo.Cliente;

/**
 * Servlet implementation class ListarPessoasServlet
 */
@WebServlet("/ListarClienteServlet")
public class ListarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("executando.....");
		
		fabricaConexao fabrica = new fabricaConexao();
		Connection conexao = fabrica.fazerConexao();
		
		ClienteDAO dao = new ClienteDAO(conexao);
		
		List<Cliente> listaCliente = dao.listarTodos();
		request.setAttribute("lista", listaCliente);
		
		fabrica.fecharConexao();
		
		RequestDispatcher rd = request.getRequestDispatcher("/listarCliente.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
