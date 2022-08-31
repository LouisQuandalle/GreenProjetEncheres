package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.Enchere;

public interface EncheresDAO {

	//Insérer un nouvel article
			public void insert(Enchere data) throws DALException;
			
			//Modifier les attributs d'un article connu en BD
			public void update(Enchere data) throws DALException;
			
			//Supprimer une enchère
			public void delete(int noUtilisateur, int noArticle) throws DALException;
			
			//Sélectionner une enchère par son NoUtilisateur & son NoArticle
			public Enchere selectByNoUtilisateurAndArticle(int noUtilisateur, int noArticle) throws DALException;
			
			//Sélectionner par son NoUtilisateur
			public List<Enchere> selectByNoUtilisateur(int noUtilisateur);
			
			//Sélectionner parNoArticle
			public List<Enchere> selectByNoArticle(int noArticle);
			
			//Sélectionner toutes les enchères
			public List<Enchere> selectAll();
	
}
