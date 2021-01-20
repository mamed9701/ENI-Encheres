package fr.eni.encheres.ihm.acquerir;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;

public class AcquerirModel {

	private ArticleVendu articleVendu;
	private Retrait retrait;
	private Enchere enchere;
	/**
	 * 
	 */
	public AcquerirModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param articleVendu
	 * @param retrait
	 * @param enchere
	 * @param profilUtilisateur
	 */
	public AcquerirModel(ArticleVendu articleVendu, Retrait retrait, Enchere enchere) {
		super();
		this.articleVendu = articleVendu;
		this.retrait = retrait;
		this.enchere = enchere;
	}
	/**
	 * @return the articleVendu
	 */
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	/**
	 * @param articleVendu the articleVendu to set
	 */
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
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
	@Override
	public String toString() {
		return "AcquerirModel [articleVendu=" + articleVendu + ", retrait=" + retrait + ", enchere=" + enchere + "]";
	}

	
	
	 

}
