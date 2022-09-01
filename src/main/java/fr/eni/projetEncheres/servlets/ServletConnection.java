package fr.eni.projetEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletConnection
 */
@WebServlet("/ServletConnection")
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/Connexion.jsp");
        rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mot_de_passe = request.getParameter("mot_de_passe");
		//Pour pouvoir se déconnecter : il faut une session
		 HttpSession session = request.getSession();
		 session.setAttribute("user", pseudo);
		
		String sql = "select mot_de_passe from UTILISATEURS where mot_de_passe = mot_de_passe";
		String sqlpseudo = "select pseudo from UTILISATEURS where pseudo = pseudo";
		
		if(pseudo.equals(sqlpseudo) && mot_de_passe.equals(sql)) {
			System.out.println("is Ok");
		}else {
			System.out.println("y a un pépin chef");
		}
	}

}
