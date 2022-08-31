package fr.eni.projetEncheres.bll;

import java.util.List;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.dal.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.DAOFactory;

public class ArticleVenduManager {
	
	private static ArticleVenduDAO articleVenduDAO;
	
	public ArticleVenduManager() throws BLLException{
		
		//Instancier le Data Access Object
		articleVenduDAO = DAOFactory.getArticleVendu();
	}
	
	public List<ArticleVendu> getArticlesVendus() throws BLLException{
		List<ArticleVendu> articleVendu=null;
		try {
			articleVendu = articleVenduDAO.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return articleVendu;
	}
	
	public void addArticleVendu(ArticleVendu newArticleVendu) throws BLLException{
		if(newArticleVendu.getNoArticle()!=null){
			throw new BLLException("Article déjà existant.");
		}
		try {
			articleVenduDAO.insert(newArticleVendu);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException("Echec ajout Article", e);
		}
		
	}
	
	public void updateArticleVendu(ArticleVendu articleVendu) throws BLLException{
		try {
			articleVenduDAO.update(articleVendu);
		} catch (DALException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void removeArticleVendu(int articleVendu) throws BLLException{
		try {
			articleVenduDAO.delete(articleVendu);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<ArticleVendu> getArticlesVendusByNoCategorie(int noCategorie) throws BLLException{
		List<ArticleVendu> articleVendu=null;
		try {
			articleVendu = articleVenduDAO.selectByNoCategorie(noCategorie);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		
		return articleVendu;
	}
		public ArticleVendu getArticleVenduByNoArticle(int noArticle) throws BLLException{
			ArticleVendu articleVendu=null;
			try {
				articleVendu = articleVenduDAO.selectByNoArticle(noArticle);
			} catch (DALException e) {
				e.printStackTrace();
			}
			
			return articleVendu;
		}
	
}
