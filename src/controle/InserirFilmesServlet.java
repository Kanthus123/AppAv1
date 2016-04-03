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

import dao.FilmesDAO;
import dao.fabricaConexao;
import modelo.Filmes;

/**
 * Servlet implementation class InserirFilmesServlet
 */
@WebServlet("/InserirFilmesServlet")
public class InserirFilmesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirFilmesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			System.out.println("Executando........");
		
			Filmes filmes = new Filmes();
			filmes.setId(Integer.parseInt(request.getParameter("id")));
			filmes.setTitulo(request.getParameter("name"));
			filmes.setAutor(request.getParameter("endereco"));
			filmes.setPreco(Float.parseFloat(request.getParameter("preco")));
			filmes.setGenero(request.getParameter("genero"));
			filmes.setAno(Integer.parseInt(request.getParameter("ano")));
			filmes.setDataCadastro(new Date());
			
			fabricaConexao fabrica = new fabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			FilmesDAO dao = new FilmesDAO(conexao);
			dao.Inserir(filmes);
			
			fabrica.fecharConexao();
			
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/novoFilme.jsp?msg=Cadastro feito com sucesso/");
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
