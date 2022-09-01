package fr.eni.projetEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projetEncheres.bll.BLLException;
import fr.eni.projetEncheres.bll.UtilisateurManager;
import fr.eni.projetEncheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletCReationCompte
 */
@WebServlet("/ServletModifCompte")
public class ServletModifCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UtilisateurManager utilisateurManager;

    public ServletModifCompte() throws BLLException {
        this.utilisateurManager = new UtilisateurManager();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/JSP/ModifierProfil.jsp");
        rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codepostal = request.getParameter("codepsotal");
		String ville = request.getParameter("ville");
		String mot_de_passe = request.getParameter("motdepasse");
		String confirmation = request.getParameter("confirmation");
		
		String code_postal = String.valueOf(codepostal);
		
		
		utilisateurManager.updateUtilisateur(Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe));
		
		
		if(confirmation.equals(mot_de_passe)) {
			System.out.println("Validation");
		}else {
			System.out.println("Mots de passe non correspondant.");
		}
		
	}

}
