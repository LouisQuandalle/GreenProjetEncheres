package fr.eni.projetEncheres.dal;

import java.sql.Date;
import java.util.List;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.UtilisateurDAO;
import fr.eni.projetEncheres.dal.jdbc.ArticleVenduDAOJdbcImpl;

public class TestDalArticleVendu {

	public static void main(String[] args) throws DALException {

		
		//Déclaration et instanciation de la DAO
		ArticleVenduDAOJdbcImpl articleVenduDAO = new ArticleVenduDAOJdbcImpl();

		Date dateEnchere1 = new Date(12-9-2022);
		Date dateVente1= new Date(12-10-2022);
		
		Date dateEnchere2= new Date(13-1-2023);
		Date dateVente2= new Date(14-1-2023);
		
		Date dateEnchere3= new Date(13-5-2023);
		Date dateVente3= new Date(14-5-2023);
		
		
		Categorie categorie1 = new Categorie(1, "informatique");
		Categorie categorie2 = new Categorie(2, "meubles");
		Categorie categorie3 = new Categorie(3, "vêtements");
		Categorie categorie4 = new Categorie(4, "electroménager");
		
		Utilisateur u2 = new Utilisateur(2, "135.3 DB", "K7", "Olivier", "K7@gmail.com","0706060606", "rue de Liverpool", "63000", "Clermont",0);
		Utilisateur u3 = new Utilisateur(3, "Fan2Canards", "Fetus", "Nicolas", "FN@gmail.com","0606060606", "rue d'Edimbrough", "01000", "Bourg-en-Bresse",0);
		
		
		//Instanciation du jeu d'essai 
		ArticleVendu a1 = new ArticleVendu("Machine à laver", "Machine Martin Electrolux occasion", dateEnchere1, dateVente1, 500, 900, u2, categorie4);
		ArticleVendu a2 = new ArticleVendu("Armoire en chêne", "Faite en 1950 par un artisan local", dateEnchere2, dateVente2, 600, 1200, u3, categorie2);
		ArticleVendu a3 = new ArticleVendu("Chemise à fleur", "Portée par Johnny Hallyday à Nice", dateEnchere3, dateVente3, 150, 45000, u2, categorie3);


		System.out.println("Ajout des articles... ");
		articleVenduDAO.insert(a1);
		System.out.println("Article ajouté  : " + a1.toString());
		articleVenduDAO.insert(a2);
		System.out.println("Article ajouté  : " + a2.toString());
		articleVenduDAO.insert(a3);
		System.out.println("Article ajouté  : " + a3.toString());

		//Sélection de l'article par no
				ArticleVendu a = articleVenduDAO.selectByNoArticle(a2.getNoArticle());
				System.out.println("\nSélection de l'article vendu par no  : " + a.toString() );


		//Sélection de tous les articles
				List<ArticleVendu> articlesVendus = articleVenduDAO.selectAll();
				System.out.println("\nSélection de tous les articles  : "  );
				afficherArticlesVendus(articlesVendus);
		
		//Modification d'un article
		System.out.println("\nModification d'un article  : " );
		System.out.println("Utilisateur avant modification : "  + a1.toString());
		a1.setNomArticle("Machine à laver sèche linge");
		a1.setDescription("La machine est en très bon état et a un compartiment qui fait du café");
		a1.setDateFinEncheres(dateVente3);
		a1.setCategorie(categorie1);
		articleVenduDAO.update(a1);
		System.out.println("Article après modification  : " + a1.toString() );
		
		
		//Suppression d'un utilisateur
		System.out.println("\nSuppression de l'article  : " + a2.toString());
		articleVenduDAO.delete(a2.getNoArticle());
		articlesVendus = articleVenduDAO.selectAll();
		System.out.println("Liste des articles après suppression : "  );
		afficherArticlesVendus(articlesVendus);
		System.out.println("---------------------------------------------------------------");

	}


	private static void afficherArticlesVendus(List<ArticleVendu> articleVendu){
		StringBuffer sb = new StringBuffer();
		for(ArticleVendu art: articleVendu){
			sb.append(art.toString());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	}