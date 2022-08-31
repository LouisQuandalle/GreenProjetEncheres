package fr.eni.projetEncheres.dal;

import fr.eni.projetEncheres.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.EncheresDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public class DAOFactory {

	public static ArticleVenduDAO getArticleVendu() {
		return new ArticleVenduDAOJdbcImpl();
	}

	public static CategorieDAO getCategorie() {
		return new CategorieDAOJdbcImpl();
	}

	public static EncheresDAO getEnchere() {
		return new EncheresDAOJdbcImpl();
	}

	public static RetraitDAO getRetrait() {
		return new RetraitDAOJdbcImpl();
	}

	public static UtilisateurDAO getUtilisateur() {
		return new UtilisateurDAOJdbcImpl();
	}
	
}
