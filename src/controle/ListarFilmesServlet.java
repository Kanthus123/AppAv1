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

import dao.FilmesDAO;
import dao.fabricaConexao;
import modelo.Filmes;

/**
 * Servlet implementation class ListarFilmesServlet
 */
@WebServlet("/ListarFilmesServlet")
public class ListarFilmesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			System.out.println("executando.....");
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			FilmesDAO dao = new FilmesDAO(conexao);
			
			List<Filmes> listaFilmes = dao.listarTodos();
			request.setAttribute("lista", listaFilmes);
			
			fabrica.fecharConexao();
			
			RequestDispatcher rd = request.getRequestDispatcher("/listarFilmes.jsp");
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
