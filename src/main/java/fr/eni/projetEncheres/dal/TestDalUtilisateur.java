package fr.eni.projetEncheres.dal;

import java.sql.Date;
import java.util.List;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni.projetEncheres.dal.jdbc.EncheresDAOJdbcImpl;


public class TestDalUtilisateur {

	public static void main(String[] args) throws DALException {

	
	//Déclaration et instanciation de la DAO
	UtilisateurDAOJdbcImpl utilisateurDAO = new UtilisateurDAOJdbcImpl();
	CategorieDAOJdbcImpl categorieDAO = new CategorieDAOJdbcImpl();
	EncheresDAOJdbcImpl enchereDAO = new EncheresDAOJdbcImpl();
	ArticleVenduDAOJdbcImpl articleVenduDAO = new ArticleVenduDAOJdbcImpl();
	RetraitDAOJdbcImpl retraitDAO = new RetraitDAOJdbcImpl();

	//Instanciation du jeu d'essai 
	Utilisateur u1 = new Utilisateur("FileasFog", "Brérot", "Yves-Romain", "Yi@gmail.com","0707070707", "rue de manchester", "59000", "Lille", "cheztatitastout");
	Utilisateur u2 = new Utilisateur("135.3 DB", "K7", "Olivier", "K7@gmail.com","0706060606", "rue de Liverpool", "63000", "Clermont", "cheztatayatouti");
	Utilisateur u3 = new Utilisateur("Fan2Canards", "Fetus", "Nicolas", "FN@gmail.com","0606060606", "rue d'Edimbrough", "01000", "Bourg-en-Bresse", "titatitutu");

	Date dateEnchere1 = new Date(2022-9-12);
	Date dateVente1= new Date(2022-10-12);
	
	Date dateEnchere2= new Date(13-1-2023);
	Date dateVente2= new Date(14-1-2023);
	
	Date dateEnchere3= new Date(13-5-2023);
	Date dateVente3= new Date(14-5-2023);
	
	
	Categorie categorie1 = new Categorie(1, "informatique");
	Categorie categorie2 = new Categorie(2, "meubles");
	Categorie categorie3 = new Categorie(3, "vêtements");
	Categorie categorie4 = new Categorie(4, "electroménager");
	
	ArticleVendu a1 = new ArticleVendu("Machine à laver", "Machine Martin Electrolux occasion", dateEnchere1, dateVente1, 500, 900, u2, categorie4);
	ArticleVendu a2 = new ArticleVendu("Armoire en chêne", "Faite en 1950 par un artisan local", dateEnchere2, dateVente2, 600, 1200, u3, categorie2);
	ArticleVendu a3 = new ArticleVendu("Chemise à fleur", "Portée par Johnny Hallyday à Nice", dateEnchere3, dateVente3, 150, 45000, u2, categorie3);

	Retrait r1 = new Retrait(a1, "Rue du père Lachaise", "75000", "Paris");
	Retrait r2 = new Retrait(a2, "Rue de la liberté", "69000", "Lyon");
	Retrait r3 = new Retrait(a3, "Boulevard du général Molinié", "13000", "Marseille");
	
	Enchere e1 = new Enchere(dateEnchere2, 420, u1, a3);
	Enchere e2 = new Enchere(dateEnchere1, 840, u2, a2);
	Enchere e3 = new Enchere(dateEnchere3, 1260, u3, a3);
	

	System.out.println("Ajout des utilisateurs... ");
	utilisateurDAO.insert(u1);
	System.out.println("Article ajouté  : " + u1.toString());
	utilisateurDAO.insert(u2);
	System.out.println("Article ajouté  : " + u2.toString());
	utilisateurDAO.insert(u3);
	System.out.println("Article ajouté  : " + u3.toString());

	
	System.out.println("Ajout des catégories....");
	categorieDAO.insert(categorie1);
	System.out.println("Catégorie ajoutée : " + categorie1.toString());
	categorieDAO.insert(categorie2);
	System.out.println("Catégorie ajoutée : " + categorie2.toString());
	categorieDAO.insert(categorie3);
	System.out.println("Catégorie ajoutée : " + categorie3.toString());
	categorieDAO.insert(categorie4);
	System.out.println("Catégorie ajoutée : " + categorie4.toString());
	
	System.out.println("Ajout d'articles... ");
	articleVenduDAO.insert(a1);
	System.out.println("Article ajouté : " + a1.toString());
	articleVenduDAO.insert(a2);
	System.out.println("Article ajouté : " + a2.toString());
	articleVenduDAO.insert(a3);
	System.out.println("Article ajouté : " + a3.toString());
	
	System.out.println("Ajout de lieu de retrait... ");
	retraitDAO.insert(r1);
	System.out.println("Lieu de retrait ajouté : " + r1.toString());
	retraitDAO.insert(r2);
	System.out.println("Lieu de retrait ajouté : " + r2.toString());
	retraitDAO.insert(r3);
	System.out.println("Lieu de retrait ajouté : " + r3.toString());
	
	System.out.println("Ajout d'une enchère.... ");
	enchereDAO.insert(e1);
	System.out.println("Enchère ajoutée : " + e1.toString());
	enchereDAO.insert(e2);
	System.out.println("Enchère ajoutée : " + e2.toString());
	enchereDAO.insert(e3);
	System.out.println("Enchère ajoutée : " + e3.toString());
	
	//Sélection de l'utilisateur par no
			Utilisateur u = utilisateurDAO.selectByNoUtilisateur(u2.getNoUtilisateur());
			System.out.println("\nSélection de l'utilisateur par no  : " + u.toString() );
			
			Categorie cat = categorieDAO.selectByNoCategorie(categorie1.getNoCategorie());
			System.out.println("\nSélection d'une catégorie par son no : " + cat.toString());
			
			ArticleVendu artNoArt = articleVenduDAO.selectByNoArticle(a1.getNoArticle());
			System.out.println("\nSélection d'un article par son no : " + artNoArt.toString());
			
			Retrait ret = retraitDAO.selectByNoArticle(r1.getArticleVendu().getNoArticle());
			System.out.println("\nSélection d'un lieu de retrait par son no d'article : " + ret.toString());
			
			Enchere encUtiArt = enchereDAO.selectByNoUtilisateurAndArticle(u2.getNoUtilisateur(), a2.getNoArticle());
			System.out.println("\nSélection d'une enchere par no d'utilisateur et d'article : " + encUtiArt.toString());


	//Sélection de tous les utilisateurs
			List<Utilisateur> utilisateurs = utilisateurDAO.selectAll();
			System.out.println("\nSélection de tous les articles  : "  );
			afficherUtilisateurs(utilisateurs);
	
	//Modification d'un utilisateur
	System.out.println("\nModification d'un utilisateur  : " );
	System.out.println("Utilisateur avant modification : "  + u1.toString());
	u1.setRue("Avenue du peuple belge");
	u1.setCodePostal("62000");
	u1.setVille("Arras");
	utilisateurDAO.update(u1);
	System.out.println("Article après modification  : " + u1.toString() );
	
	
	//Suppression d'un utilisateur
	System.out.println("\nSuppression de l'article  : " + u1.toString());
	utilisateurDAO.delete(u1.getNoUtilisateur());
	utilisateurs = utilisateurDAO.selectAll();
	System.out.println("Liste des articles après suppression : "  );
	afficherUtilisateurs(utilisateurs);
	System.out.println("---------------------------------------------------------------");

}


private static void afficherUtilisateurs(List<Utilisateur> utilisateur){
	StringBuffer sb = new StringBuffer();
	for(Utilisateur uti: utilisateur){
		sb.append(uti.toString());
		sb.append("\n");
	}
	System.out.println(sb.toString());
}
}
