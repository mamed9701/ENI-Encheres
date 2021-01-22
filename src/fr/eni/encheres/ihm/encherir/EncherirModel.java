package fr.eni.encheres.ihm.encherir;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

public class EncherirModel {

	private ArticleVendu article;
	private Retrait retrait;
	private Enchere enchere;
	private Utilisateur user;
	private Integer maProposition;

	/**
	 * 
	 */
	public EncherirModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param articleVendu
	 * @param retrait
	 * @param enchere
	 * @param user
	 * @param maProposition
	 */
	public EncherirModel(ArticleVendu article, Retrait retrait, Enchere enchere, Utilisateur user,
			Integer maProposition) {
		super();
		this.article = article;
		this.retrait = retrait;
		this.enchere = enchere;
		this.user = user;
		this.maProposition = maProposition;
	}

	/**
	 * @return the articleVendu
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * @param articleVendu the articleVendu to set
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
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
	 * @return the enchere
	 */
	public Enchere getEnchere() {
		return enchere;
	}

	/**
	 * @param enchere the enchere to set
	 */
	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

	/**
	 * @return the user
	 */
	public Utilisateur getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Utilisateur user) {
		this.user = user;
	}

	/**
	 * @return the maProposition
	 */
	public Integer getMaProposition() {
		return maProposition;
	}

	/**
	 * @param maProposition the maProposition to set
	 */
	public void setMaProposition(Integer maProposition) {
		this.maProposition = maProposition;
	}

	@Override
	public String toString() {
		return "EncherirModel [article=" + article + ", retrait=" + retrait + ", enchere=" + enchere
				+ ", user=" + user + ", maProposition=" + maProposition + "]";
	}

}
