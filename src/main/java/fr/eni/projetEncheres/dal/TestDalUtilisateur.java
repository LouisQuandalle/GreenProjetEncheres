package fr.eni.projetEncheres.dal;

import java.util.List;


import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.jdbc.UtilisateurDAOjdbcImpl;


public class TestDalUtilisateur {

	public static void main(String[] args) throws DALException {

	
	//Déclaration et instanciation de la DAO
	UtilisateurDAOjdbcImpl utilisateurDAO = new UtilisateurDAOjdbcImpl();

	//Instanciation du jeu d'essai 
	Utilisateur u1 = new Utilisateur("xXDarkSasuke59Xx", "Bitybrérot", "Yves-Romain", "Yi@gmail.com","0707070707", "rue de manchester", "59000", "Lille", "cheztatitastout");
	Utilisateur u2 = new Utilisateur("135.3 DB", "K7", "Olivier", "K7@gmail.com","0706060606", "rue de Liverpool", "63000", "Clermont", "cheztatayatouti");
	Utilisateur u3 = new Utilisateur("Fan2Canards", "Fetus", "Nicolas", "FN@gmail.com","0606060606", "rue d'Edimbrough", "01000", "Bourg-en-Bresse", "titatitutu");


	System.out.println("Ajout des utilisateurs... ");
	utilisateurDAO.insert(u1);
	System.out.println("Article ajouté  : " + u1.toString());
	utilisateurDAO.insert(u2);
	System.out.println("Article ajouté  : " + u2.toString());
	utilisateurDAO.insert(u3);
	System.out.println("Article ajouté  : " + u3.toString());

	//Sélection de l'utilisateur par no
			Utilisateur u = utilisateurDAO.selectByNoUtilisateur(u2.getNoUtilisateur());
			System.out.println("\nSélection de l'utilisateur par no  : " + u.toString() );


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
