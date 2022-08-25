package fr.eni.projetEncheres.dal;

import fr.eni.projetEncheres.bo.Categorie;

public interface CategorieDAO {


            //Insérer une nouvelle categorie
            public void insert(Categorie data) throws DALException;

            //Modifier les attributs d'une categorie connu en BD
            public void update(Categorie data) throws DALException;

            //Supprimer une categorie
            public void delete(int noCategorie) throws DALException;

            //Sélectionner une categorie par son noCategorie
            public Categorie selectById(int noCategorie) throws DALException;
}