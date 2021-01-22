package fr.eni.encheres.ihm.accueil;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public class AccueilModel {
	private Utilisateur currentUser;
	private String filtre;
	private List<Categorie> listCategories = new ArrayList<>();
	private List<Enchere> listEncheres = new ArrayList<>();
	private List<ArticleVendu> listArticles = new ArrayList<>();
	private List<ArticleVendu> listArticlesByUser = new ArrayList<>();

	/**
	 * 
	 */
	public AccueilModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param filtre
	 * @param listCategories
	 * @param listEncheres
	 */
	public AccueilModel(String filtre) {
		super();
		this.filtre = filtre;
	}

	/**
	 * @return the filtre
	 */
	public String getFiltre() {
		return filtre;
	}

	/**
	 * @param filtre the filtre to set
	 */
	public void setFiltre(String filtre) {
		this.filtre = filtre;
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
	 * @return the listEncheres
	 */
	public List<Enchere> getListEncheres() {
		return listEncheres;
	}

	/**
	 * @param listEncheres the listEncheres to set
	 */
	public void setListEncheres(List<Enchere> listEncheres) {
		this.listEncheres = listEncheres;
	}

	public List<ArticleVendu> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<ArticleVendu> listArticles) {
		this.listArticles = listArticles;
	}

	public List<ArticleVendu> getListArticlesByUser() {
		return listArticlesByUser;
	}

	public void setListArticlesByUser(List<ArticleVendu> listArticlesByUser) {
		this.listArticlesByUser = listArticlesByUser;
	}

	public Utilisateur getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Utilisateur currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public String toString() {
		return "AccueilModel [filtre=" + filtre + ", listCategories=" + listCategories + "]";
	}

}
