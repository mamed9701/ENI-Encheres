package fr.eni.encheres.ihm.finEnchere;

import fr.eni.encheres.bo.ArticleVendu;

public class FinEnchereModel {

	private String mOffre;
	private ArticleVendu article;

	/**
	 * 
	 */
	public FinEnchereModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param mOffre
	 * @param article
	 */
	public FinEnchereModel(String mOffre, ArticleVendu article) {
		super();
		this.mOffre = mOffre;
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

	@Override
	public String toString() {
		return "FinEnchereModel [mOffre=" + mOffre + ", article=" + article + "]";
	}

}
