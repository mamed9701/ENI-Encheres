package fr.eni.encheres.ihm.encherir;

import fr.eni.encheres.bo.ArticleVendu;

public class EncherirModel {

	private ArticleVendu article;
	private String mOffre;
	private Integer maProposition;

	/**
	 * 
	 */
	public EncherirModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param article
	 * @param mOffre
	 * @param maProposition
	 */
	public EncherirModel(ArticleVendu article, String mOffre, Integer maProposition) {
		super();
		this.article = article;
		this.mOffre = mOffre;
		this.maProposition = maProposition;
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
	 * @return the mOffre
	 */
	public String getmOffre() {
		return mOffre;
	}

	/**
	 * @param mOffre the mOffre to set
	 */
	public void setmOffre(String mOffre) {
		this.mOffre = mOffre;
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
		return "EncherirModel [article=" + article + ", mOffre=" + mOffre + ", maProposition=" + maProposition + "]";
	}

}
