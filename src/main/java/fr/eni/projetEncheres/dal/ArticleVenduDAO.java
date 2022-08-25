package fr.eni.projetEncheres.dal;

import fr.eni.projetEncheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	

			//Insérer un nouvel article
			public void insert(ArticleVendu data) throws DALException;
			
			//Modifier les attributs d'un article connu en BD
			public void update(ArticleVendu data) throws DALException;
			
			//Supprimer un article
			public void delete(int noArticle) throws DALException;
			
			//Sélectionner un article par son idArticle
			public ArticleVendu selectById(int noArticle, int noUtilisateur, int noCategorie) throws DALException;
}
