package fr.eni.projetEncheres.bll;

import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.dal.DALException;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.UtilisateurDAO;

public class UtilisateurManager {

private static UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() throws BLLException{
		
		//Instancier le Data Access Object
		utilisateurDAO = DAOFactory.getUtilisateur();
	}
	
	public List<Utilisateur> getUtilisateur() throws BLLException{
		List<Utilisateur> utilisateur=null;
		try {
			utilisateur = utilisateurDAO.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return utilisateur;
	}
	
	public void addUtilisateur(Utilisateur newUtilisateur) throws BLLException{
		if(newUtilisateur.getNoUtilisateur()!=null){
		}
		try {
			utilisateurDAO.insert(newUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUtilisateur(Utilisateur utilisateur) throws BLLException{
		try {
			utilisateurDAO.update(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void removeUtilisateur(int noUtilisateur) throws BLLException{
		try {
			utilisateurDAO.delete(noUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}
	
	public Utilisateur getUtilisateurByNoUtilisateur(int id) throws BLLException{
		Utilisateur utilisateur=null;
		try {
			utilisateur = utilisateurDAO.selectByNoUtilisateur(id);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return utilisateur;
	}
}
