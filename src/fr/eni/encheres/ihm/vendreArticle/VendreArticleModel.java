package fr.eni.encheres.ihm.vendreArticle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;

public class VendreArticleModel {

	private String article;
	private String description;
	private List<Categorie> listCategories = new ArrayList<>();
	private Integer miseAPrix;
	private LocalDate debutEnchere;
	private LocalDate finEnchere;
	private Retrait retrait;

	/**
	 * 
	 */
	public VendreArticleModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param article
	 * @param description
	 * @param listCategories
	 * @param miseAPrix
	 * @param debutEnchere
	 * @param finEnchere
	 * @param retrait
	 */
	public VendreArticleModel(String article, String description, List<Categorie> listCategories, Integer miseAPrix,
			LocalDate debutEnchere, LocalDate finEnchere, Retrait retrait) {
		super();
		this.article = article;
		this.description = description;
		this.listCategories = listCategories;
		this.miseAPrix = miseAPrix;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.retrait = retrait;
	}

	/**
	 * @return the article
	 */
	public String getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(String article) {
		this.article = article;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the miseAPrix
	 */
	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	/**
	 * @param miseAPrix the miseAPrix to set
	 */
	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	/**
	 * @return the debutEnchere
	 */
	public LocalDate getDebutEnchere() {
		return debutEnchere;
	}

	/**
	 * @param debutEnchere the debutEnchere to set
	 */
	public void setDebutEnchere(LocalDate debutEnchere) {
		this.debutEnchere = debutEnchere;
	}

	/**
	 * @return the finEnchere
	 */
	public LocalDate getFinEnchere() {
		return finEnchere;
	}

	/**
	 * @param finEnchere the finEnchere to set
	 */
	public void setFinEnchere(LocalDate finEnchere) {
		this.finEnchere = finEnchere;
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

	@Override
	public String toString() {
		return "VendreArticleModel [article=" + article + ", description=" + description + ", listCategories="
				+ listCategories + ", miseAPrix=" + miseAPrix + ", debutEnchere=" + debutEnchere + ", finEnchere="
				+ finEnchere + ", retrait=" + retrait + "]";
	}

}
