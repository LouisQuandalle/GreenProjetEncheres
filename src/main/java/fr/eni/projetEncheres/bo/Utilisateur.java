package fr.eni.projetEncheres.bo;

import java.util.List;

public class Utilisateur {
	

	private Integer no_utilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String code_postal;
	private String ville;
	private String mot_de_passe;
	private Integer credit = 0;
	private boolean administrateur = false;
	List<Enchere> encherit;
	List<ArticleVendu> achete;
	List<ArticleVendu> vend;
	
	public Utilisateur() {
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = codePostal;
		this.ville = ville;
		
		
	}
	
	public Utilisateur(Integer no_utilisateur,String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, Integer credit) {
		super();
		this.no_utilisateur= no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = codePostal;
		this.ville = ville;
		this.credit = credit;
		
		
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = codePostal;
		this.ville = ville;
		this.mot_de_passe = motDePasse;
		
		
	}
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur,
			List<Enchere> encherit, List<ArticleVendu> achete, List<ArticleVendu> vend) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = codePostal;
		this.ville = ville;
		this.mot_de_passe = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.encherit = encherit;
		this.achete = achete;
		this.vend = vend;
		
		
	}

	
	public Utilisateur(Integer noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, Integer credit, boolean administrateur,
			List<Enchere> encherit, List<ArticleVendu> achete, List<ArticleVendu> vend) {
		super();
		this.no_utilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = codePostal;
		this.ville = ville;
		this.mot_de_passe = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.encherit = encherit;
		this.achete = achete;
		this.vend = vend;
		
		
	}

	public Integer getNoUtilisateur() {
		return no_utilisateur;
	}

	public void setNoUtilisateur(Integer noUtilisateur) {
		this.no_utilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return code_postal;
	}

	public void setCodePostal(String codePostal) {
		this.code_postal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMotDePasse() {
		return mot_de_passe;
	}

	public void setMotDePasse(String motDePasse) {
		this.mot_de_passe = motDePasse;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public boolean getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public List<Enchere> getEncherit() {
		return encherit;
	}

	public void setEncherit(List<Enchere> encherit) {
		this.encherit = encherit;
	}

	public List<ArticleVendu> getAchete() {
		return achete;
	}

	public void setAchete(List<ArticleVendu> achete) {
		this.achete = achete;
	}

	public List<ArticleVendu> getVend() {
		return vend;
	}

	public void setVend(List<ArticleVendu> vend) {
		this.vend = vend;
	}

	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + no_utilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ code_postal + ", ville=" + ville + ", motDePasse=" + mot_de_passe + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", encherit=" + encherit + ", achete=" + achete + ", vend="
				+ vend + "]";
	}
	
}
