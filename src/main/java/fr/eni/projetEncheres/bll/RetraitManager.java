package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.bo.Retrait;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.RetraitDAO;

public class RetraitManager {

private static RetraitDAO retraitDAO;

	public RetraitManager() throws BLLException{
		

		//Instancier le Data Access Object
		retraitDAO = DAOFactory.getRetrait();
	}
	
	public void addRetrait(Retrait newRetrait) throws BLLException{
		if(newRetrait.getArticleVendu()!=null){
		}
		try {
			retraitDAO.insert(newRetrait);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateRetrait(Retrait retrait) throws BLLException{
		try {
			retraitDAO.update(retrait);
		} catch (DALException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void removeRetrait(int noArticle) throws BLLException{
		try {
			retraitDAO.delete(noArticle);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public Retrait getRetraitByNoArticle(int noArticle) throws BLLException{
		Retrait retrait=null;
		try {
			retrait = retraitDAO.selectByNoArticle(noArticle);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return retrait;
	}
}