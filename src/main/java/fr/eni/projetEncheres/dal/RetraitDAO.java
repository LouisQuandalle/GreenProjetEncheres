package fr.eni.projetEncheres.dal;

import fr.eni.projetEncheres.bo.Retrait;

public interface RetraitDAO {
			
			
			//Modifier les attributs d'un lieu de retrait connu en BD
			public void update(Retrait data) throws DALException;
			
			//Insérer un nouveau lieu de retrait
			public void insert(Retrait data) throws DALException;
			
			//Supprimer un article
			public void delete(int noArticle) throws DALException;
			
			//Sélectionner un lieuDeretrait par le noArticle
			public Retrait selectByNoArticle(int noArticle) throws DALException;
}
