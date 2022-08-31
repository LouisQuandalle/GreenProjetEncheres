package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.ArticleVendu;

public interface ArticleVenduDAO {
	

			//Insérer un nouvel article
			public void insert(ArticleVendu data) throws DALException;
			
			//Modifier les attributs d'un article connu en BD
			public void update(ArticleVendu data) throws DALException;
			
			//Supprimer un article
			public void delete(int noArticle) throws DALException;
			
			//Sélectionner un article par son idArticle
			public ArticleVendu selectByNoArticle(int noArticle) throws DALException;
			
			//Selectionner des article par son NoCategorie
			public List<ArticleVendu> selectByNoCategorie(int noCategorie) throws DALException;
			
			//Selectionner tous les articles
			public List<ArticleVendu> selectAll() throws DALException;
}
