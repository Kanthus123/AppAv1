package controle;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

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
 * Servlet implementation class InserirClientesServlet
 */
@WebServlet("/InserirClientesServlet")
public class InserirClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println("Executando........");
		
			Cliente cliente = new Cliente();
			cliente.setCpf(Integer.parseInt(request.getParameter("cpf")));
			cliente.setName(request.getParameter("name"));
			cliente.setEndereco(request.getParameter("endereco"));
			cliente.setTel(request.getParameter("tel"));
			cliente.setIdade(Integer.parseInt(request.getParameter("idade")));
			cliente.setDataCadastro(new Date());
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			ClienteDAO dao = new ClienteDAO(conexao);
			dao.Inserir(cliente);
			
			fabrica.fecharConexao();
			
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/novoCliente.jsp?msg=Cadastro feito com sucesso/");
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
