package fr.eni.encheres.bo;

import java.time.LocalDate;

public class ArticleVendu {

	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private Categorie categorie;
	private Utilisateur utilisateur;

	/**
	 * 
	 */
	public ArticleVendu() {
		super();
	}
    
	/**
     * @param noArticle
     * @param nomArticle
     * @param description
     * @param dateDebutEncheres
     * @param dateFinEncheres
     * @param miseAPrix
     * @param prixVente
     */
    public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
            LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente) {
        super();
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
    }

    /**
     * @param nomArticle
     * @param description
     * @param dateDebutEncheres
     * @param dateFinEncheres
     * @param miseAPrix
     * @param prixVente
     */
    public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres,
            LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente) {
        super();
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
    }
    
    /**
     * @param nomArticle
     * @param description
     * @param dateDebutEncheres
     * @param dateFinEncheres
     * @param miseAPrix
     * @param prixVente
     * @param utilisateur
     * @param categorie
     */
    public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres,
            LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Utilisateur utilisateur, Categorie categorie) {
        super();
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
    }
    
    /**
     * @param noArticle
     * @param nomArticle
     * @param description
     * @param dateDebutEncheres
     * @param dateFinEncheres
     * @param miseAPrix
     * @param prixVente
     * @param utilisateur
     * @param categorie
     */
    public ArticleVendu(Integer noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
            LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente, Utilisateur utilisateur, Categorie categorie) {
        super();
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
    }
    
	/**
	 * @return the noArticle
	 */
	public Integer getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
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
	 * @return the dateDebutEncheres
	 */
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	/**
	 * @param dateDebutEncheres the dateDebutEncheres to set
	 */
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	/**
	 * @return the dateFinEncheres
	 */
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	/**
	 * @param dateFinEncheres the dateFinEncheres to set
	 */
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
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
	 * @return the prixVente
	 */
	public Integer getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", categorie=" + categorie + "]";
	}

}
