package fr.eni.encheres.ihm.afficherUtilisateur;

import fr.eni.encheres.bo.Utilisateur;

public class AfficherUtilisateurModel {

	private Utilisateur utilisateur;

	/**
	 * 
	 */
	public AfficherUtilisateurModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param utilisateur
	 */
	public AfficherUtilisateurModel(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
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
		return "AfficherUtilisateurModel [utilisateur=" + utilisateur + "]";
	}

}
