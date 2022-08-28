package fr.eni.projetEncheres.bo;

import java.sql.Date;

public class Enchere {
	private Date dateEnchere;
	private Integer montantEnchere;
	private Utilisateur encherisseur;
	private ArticleVendu articleVendu;
	
	public Enchere() {
	}

	public Enchere(Date dateEnchere, Integer montantEnchere, Utilisateur encherisseur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
	}

	public Enchere(Date dateEnchere, Integer montantEnchere, ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articleVendu = articleVendu;
	}

	public Enchere(Date dateEnchere, Integer montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public Enchere(Date dateEnchere2, Integer montantEnchere, Utilisateur encherisseur,
			ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere2;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
		this.articleVendu = articleVendu;
	}

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
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
