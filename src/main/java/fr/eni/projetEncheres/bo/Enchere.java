package fr.eni.projetEncheres.bo;

import java.sql.Time;

public class Enchere {
	private Time dateEnchere;
	private Integer montantEnchere;
	private Utilisateur encherisseur;
	private ArticleVendu articleVendu;
	
	public Enchere() {
	}

	public Enchere(Time dateEnchere, Integer montantEnchere, Utilisateur encherisseur,
			ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
		this.articleVendu = articleVendu;
	}

	public Time getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Time dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + ", encherisseur="
				+ encherisseur + ", articleVendu=" + articleVendu + "]";
	}
	
	
}
