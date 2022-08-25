package fr.eni.projetEncheres.bo;

import java.util.List;

public class Categorie {
    private Integer noCategorie;
    private String libelle;
    List<ArticleVendu> articlesVendus;

public Categorie() {
}

public Categorie(Integer noCategorie, String libelle, List<ArticleVendu> articlesVendus) {
    super();
    this.noCategorie = noCategorie;
    this.libelle = libelle;
    this.articlesVendus = articlesVendus;
}

public Integer getNoCategorie() {
    return noCategorie;
}

public void setNoCategorie(Integer noCategorie) {
    this.noCategorie = noCategorie;
}

public String getLibelle() {
    return libelle;
}

public void setLibelle(String libelle) {
    this.libelle = libelle;
}

public List<ArticleVendu> getArticlesVendus() {
    return articlesVendus;
}

public void setArticlesVendus(List<ArticleVendu> articlesVendus) {
    this.articlesVendus = articlesVendus;
}

@Override
public String toString() {
    return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", articlesVendus=" + articlesVendus
            + "]";
}


}
