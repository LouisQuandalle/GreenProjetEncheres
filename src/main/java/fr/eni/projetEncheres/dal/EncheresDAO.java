package fr.eni.projetEncheres.dal;

import fr.eni.projetEncheres.bo.Enchere;

public interface EncheresDAO {

	//Insérer un nouvel article
			public void insert(Enchere data) throws DALException;
			
			//Modifier les attributs d'un article connu en BD
			public void update(Enchere data) throws DALException;
			
			//Supprimer une enchère
			public void delete(int noUtilisateur, int noArticle) throws DALException;
			
			//Sélectionner une enchère par son idArticle
			public Enchere selectById(int noUtilisateur, int noArticle) throws DALException;
	
}
