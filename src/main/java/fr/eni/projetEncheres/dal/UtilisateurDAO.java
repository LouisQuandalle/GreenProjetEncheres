package fr.eni.projetEncheres.dal;

import fr.eni.projetEncheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	
		//Insérer un nouvel article
		public void insert(Utilisateur data) throws DALException;
		
		//Modifier les attributs d'un article connu en BD
		public void update(Utilisateur data) throws DALException;
		
		//Supprimer un article
		public void delete(int noUtilisateur) throws DALException;
		
		//Sélectionner un article par son idArticle
		public Utilisateur selectById(int id) throws DALException;
		
}
