package fr.eni.projetEncheres.bo;

import java.sql.Time;
import java.util.List;

public class ArticleVendu {
	private Integer noArticle;
	private String nomArticle;
	private String description;
	private Time dateDebutEncheres;
	private Time dateFinEncheres;
	private Integer prixInitial;
	private Integer prixVente;
	private boolean etatVente;
	private Utilisateur acheteur;
	private Utilisateur vendeur;
	private Categorie categorie;
	List<Enchere> encheres;
	private Retrait lieuRetrait;
	
	public ArticleVendu() {
	}

	public ArticleVendu(String nomArticle, String description, Time dateDebutEncheres,
			Time dateFinEncheres, int prixInitial, int prixVente, Utilisateur vendeur, Categorie categorie) 
	{
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}
	
	public ArticleVendu(Integer noArticle, String nomArticle, String description, Time dateDebutEncheres,
			Time dateFinEncheres, Integer prixInitial, Integer prixVente, boolean etatVente,
			Utilisateur acheteur, Utilisateur vendeur, Categorie categorie, List<Enchere> encheres,
			Retrait lieuRetrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.acheteur = acheteur;
		this.vendeur = vendeur;
		this.categorie = categorie;
		this.encheres = encheres;
		this.lieuRetrait = lieuRetrait;
	}

	

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Time getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(Time dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public Time getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(Time dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public Integer getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(Integer prixInitial) {
		this.prixInitial = prixInitial;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public boolean isEtatVente() {
		return etatVente;
	}

	public void setEtatVente(boolean etatVente) {
		this.etatVente = etatVente;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	
	
}

