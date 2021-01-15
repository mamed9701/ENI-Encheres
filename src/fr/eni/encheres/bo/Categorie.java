package fr.eni.encheres.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private Integer noCategorie;
	private String libelle;
	private List<ArticleVendu> listArticlesVendus = new ArrayList<>();

	/**
	 * 
	 */
	public Categorie() {
		super();
	}

	/**
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	/**
     * @param libelle
     */
    public Categorie(String libelle) {
        super();
        this.libelle = libelle;
    }

	/**
	 * @return the noCategorie
	 */
	public Integer getNoCategorie() {
		return noCategorie;
	}

	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the listArticles
	 */
	public List<ArticleVendu> getListArticlesVendus() {
		return listArticlesVendus;
	}

	/**
	 * @param listArticles the listArticles to set
	 */
	public void setListArticlesVendus(List<ArticleVendu> listArticles) {
		this.listArticlesVendus = listArticles;
	}

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", listArticles=" + listArticlesVendus
				+ "]";
	}

}
