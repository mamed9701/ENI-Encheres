package fr.eni.encheres.ihm.inscription;

import fr.eni.encheres.bo.Utilisateur;

public class InscriptionModel {
	private Utilisateur creaUtilisateur;
	private String confirmation;
	

	/**
	 * 
	 */
	public InscriptionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param creaUtilisateur
	 * @param confirmation
	 */
	public InscriptionModel(Utilisateur creaUtilisateur, String confirmation) {
		super();
		this.creaUtilisateur = creaUtilisateur;
		this.confirmation = confirmation;
	}
	
	/**
	 * @return the creaUtilisateur
	 */
	public Utilisateur getCreaUtilisateur() {
		return creaUtilisateur;
	}

	/**
	 * @param creaUtilisateur the creaUtilisateur to set
	 */
	public void setCreaUtilisateur(Utilisateur creaUtilisateur) {
		this.creaUtilisateur = creaUtilisateur;
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
		return "CreationCompteModel [creaUtilisateur=" + creaUtilisateur + ", confirmation=" + confirmation + "]";
	}

}
