package fr.eni.encheres.ihm.encherir;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

public class EncherirModel {

	private ArticleVendu articleVendu;
	private Retrait retrait;
	private Enchere enchere;
	private Utilisateur profilUtilisateur;
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
	 * @param profilUtilisateur
	 * @param maProposition
	 */
	public EncherirModel(ArticleVendu articleVendu, Retrait retrait, Enchere enchere, Utilisateur profilUtilisateur,
			Integer maProposition) {
		super();
		this.articleVendu = articleVendu;
		this.retrait = retrait;
		this.enchere = enchere;
		this.profilUtilisateur = profilUtilisateur;
		this.maProposition = maProposition;
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
		return "EncherirModel [articleVendu=" + articleVendu + ", retrait=" + retrait + ", enchere=" + enchere
				+ ", profilUtilisateur=" + profilUtilisateur + ", maProposition=" + maProposition + "]";
	}

}
