package misServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreAdmin = this.getServletConfig().getInitParameter("nombreAdmin");
		String claveAdmin = this.getServletConfig().getInitParameter("claveAdmin");
		String nombreUsuario = this.getServletConfig().getInitParameter("nombreUsuario");
		String claveUsuario = this.getServletConfig().getInitParameter("claveUsuario");
		String nombreIngresado = request.getParameter("nombre");
		String claveIngresada = request.getParameter("clave");
		
		if ((nombreAdmin.equals(nombreIngresado)) && (claveAdmin.equals(claveIngresada))  ){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/administradorAdminUsuarios.jsp");
			if (dispatcher != null) {
				dispatcher.forward(request, response);
			} 
			
		}else if ((nombreUsuario.equals(nombreIngresado)) && (claveUsuario.equals(claveIngresada))) {
			RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/misrutas.jsp");
			if (dispatcher1 != null) {
				dispatcher1.forward(request, response);
			} 
	    }else {response.sendRedirect("errorPermisos.jsp");
	          }

  }
}
