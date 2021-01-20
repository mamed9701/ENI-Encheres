package fr.eni.encheres.ihm.inscription;

import fr.eni.encheres.bo.Utilisateur;

public class InscriptionModel {
	private Utilisateur utilisateur;
	private String confirmation;
	

	/**
	 * 
	 */
	public InscriptionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param utilisateur
	 * @param confirmation
	 */
	public InscriptionModel(Utilisateur utilisateur, String confirmation) {
		super();
		this.utilisateur = utilisateur;
		this.confirmation = confirmation;
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

	/**
	 * @return the confirmation
	 */
	public String getConfirmation() {
		return confirmation;
	}

	/**
	 * @param confirmation the confirmation to set
	 */
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	@Override
	public String toString() {
		return "CreationCompteModel [utilisateur=" + utilisateur + ", confirmation=" + confirmation + "]";
	}

}
