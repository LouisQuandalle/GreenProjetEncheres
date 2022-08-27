package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	
		//Insérer un nouvel article
		public void insert(Utilisateur data) throws DALException;
		
		//Modifier les attributs d'un utilisateur connu en BD
		public void update(Utilisateur data) throws DALException;
		
		//Supprimer un utilisateur
		public void delete(int noUtilisateur) throws DALException;
		
		//Sélectionner un utilisatuer par son idUtilisateur
		public Utilisateur selectByNoUtilisateur(int id) throws DALException;
		
		//Selectionner tout utilisateurs
		public List<Utilisateur> selectAll() throws DALException;
}
