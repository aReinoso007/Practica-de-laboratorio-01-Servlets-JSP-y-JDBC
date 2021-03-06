package ec.ups.edu.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ups.edu.dao.DAOFactory;
import ec.ups.edu.dao.UsuarioDAO;
import ec.ups.edu.modelo.Usuario;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String nombre ="";
		String apellido ="";
		String cedula ="";
		String correo ="";
		String pwd="";
		
		Usuario user = new Usuario();
		
		String resp = request.getParameter("resp");
		UsuarioDAO usuDAO = DAOFactory.getFactory().getUsuarioDAO();
		if(resp.equals("Registrarse")) {
			nombre = request.getParameter("nombre");
			apellido = request.getParameter("apellido");
			cedula = request.getParameter("cdi");
			correo = request.getParameter("email");
			pwd = request.getParameter("password");
			
			user = new Usuario(cedula, nombre, apellido, correo, pwd);
			
			usuDAO.create(user);
			getServletContext().getRequestDispatcher("/JSPs/ExitoCreacion.jsp").forward(request, response);
		}
	}

}
