package fr.eni.encheres.ihm.finEnchere;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

public class FinEnchereModel {
	
	private ArticleVendu articleVendu;
	private Retrait retrait;
	private Enchere enchere;
	private Utilisateur profilUtilisateur;

	/**
	 * 
	 */
	public FinEnchereModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param articleVendu
	 * @param enchere
	 * @param profilUtilisateur
	 */
	public FinEnchereModel(ArticleVendu articleVendu, Retrait retrait, Enchere enchere,  Utilisateur profilUtilisateur) {
		super();
		this.articleVendu = articleVendu;
		this.retrait = retrait;
		this.enchere = enchere;
		this.profilUtilisateur = profilUtilisateur;
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
	 * @return the enchere
	 */
	public Retrait getRetrait() {
		return retrait;
	}

	/**
	 * @param enchere the enchere to set
	 */
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	/**
	 * @return the profilUtilisateur
	 */
	public Utilisateur getProfilUtilisateur() {
		return profilUtilisateur;
	}

	/**
	 * @param profilUtilisateur the profilUtilisateur to set
	 */
	public void setProfilUtilisateur(Utilisateur profilUtilisateur) {
		this.profilUtilisateur = profilUtilisateur;
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
		return "FinEnchereModel [articleVendu=" + articleVendu + ", retrait=" + retrait + ", enchere=" + enchere
				+ ", profilUtilisateur=" + profilUtilisateur + "]";
	}

	

	
}
