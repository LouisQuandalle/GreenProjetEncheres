package fr.eni.projetEncheres.bll;

import java.util.List;

import fr.eni.projetEncheres.bo.Enchere;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.EncheresDAO;

public class EncheresManager {

private static EncheresDAO encheresDAO;
	
	public EncheresManager() throws BLLException{
		
		//Instancier le Data Access Object
		encheresDAO = DAOFactory.getEnchere();
	}
	
	public Enchere getEnchereByNoUtilisateurAndArticle(int noUtilisateur, int noArticle) throws BLLException{
		Enchere enchere=null;
		try {
			enchere = encheresDAO.selectByNoUtilisateurAndArticle(noUtilisateur, noArticle);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return enchere;
	}
	
	public void addEnchere(Enchere newEnchere) throws BLLException{
		if(newEnchere.getArticleVendu()!=null){
		}
		try {
			encheresDAO.insert(newEnchere);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateEnchere(Enchere enchere) throws BLLException{
		try {
			encheresDAO.update(enchere);
		} catch (DALException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void removeEnchere(int noUtilisateur, int noArticle) throws BLLException{
		try {
			encheresDAO.delete(noUtilisateur, noArticle);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Enchere> getEnchereByNoUtilisateur(int noUtilisateur) throws BLLException, DALException{
		List<Enchere> enchere=null;
		enchere = encheresDAO.selectByNoUtilisateur(noUtilisateur);
				
		return enchere;
	}
	
	public List<Enchere> getEnchereByNoArticle(int noArticle) throws BLLException, DALException{
		List<Enchere> enchere=null;
		enchere = encheresDAO.selectByNoArticle(noArticle);
				
		return enchere;
	}
	
}
