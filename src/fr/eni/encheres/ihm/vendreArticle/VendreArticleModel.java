package fr.eni.encheres.ihm.vendreArticle;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

public class VendreArticleModel {

	private ArticleVendu article;
	private List<Categorie> listCategories = new ArrayList<>();
	private Retrait retrait;
	private Utilisateur utilisateur;

	public VendreArticleModel() {
		super();
	}

	/**
	 * @param article
	 * @param listCategories
	 * @param retrait
	 */
	public VendreArticleModel(ArticleVendu article, List<Categorie> listCategories, Retrait retrait) {
		super();
		this.article = article;
		this.listCategories = listCategories;
		this.retrait = retrait;
	}

	/**
	 * @return the article
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	/**
	 * @return the listCategories
	 */
	public List<Categorie> getListCategories() {
		return listCategories;
	}

	/**
	 * @param listCategories the listCategories to set
	 */
	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	/**
	 * @return the retrait
	 */
	public Retrait getRetrait() {
		return retrait;
	}

	/**
	 * @param retrait the retrait to set
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "VendreArticleModel [article=" + article + ", listCategories=" + listCategories + ", retrait=" + retrait
				+ ", utilisateur=" + utilisateur + "]";
	}

	

}