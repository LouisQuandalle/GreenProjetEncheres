package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.bo.Categorie;
import fr.eni.projetEncheres.dal.CategorieDAO;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.DAOFactory;

public class CategorieManager {

private static CategorieDAO categorieDAO;
	
	public CategorieManager() throws BLLException{
		
		//Instancier le Data Access Object
		categorieDAO = DAOFactory.getCategorie();
	}
	
	public void addCategorie(Categorie newCategorie) throws BLLException{
		if(newCategorie.getNoCategorie()!=null){
		}
		try {
			categorieDAO.insert(newCategorie);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateCategorie(Categorie categorie) throws BLLException{
		try {
			categorieDAO.update(categorie);
		} catch (DALException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void removeCategorie(int noCategorie) throws BLLException{
		try {
			categorieDAO.delete(noCategorie);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

	public Categorie getCategorieByNoCategorie(int noCategorie) throws BLLException{
		Categorie categorie=null;
		try {
			categorie = categorieDAO.selectByNoCategorie(noCategorie);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return categorie;
	}
}
