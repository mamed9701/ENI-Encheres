package fr.eni.encheres.ihm.modifierUtilisateur;

import fr.eni.encheres.bo.Utilisateur;

public class ModifierProfilModel {
	private Utilisateur modifUtilisateur;
	private String confirmation;
	private String mdpActuel;
	private String messagePseudo;

	/**
	 * 
	 */
	public ModifierProfilModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param modifUtilisateur
	 * @param confirmation
	 * @param mdpActuel
	 */
	public ModifierProfilModel(Utilisateur modifUtilisateur, String confirmation, String mdpActuel) {
		super();
		this.modifUtilisateur = modifUtilisateur;
		this.confirmation = confirmation;
		this.mdpActuel = mdpActuel;
	}

	/**
	 * @return the modifUtilisateur
	 */
	public Utilisateur getModifUtilisateur() {
		return modifUtilisateur;
	}

	/**
	 * @param modifUtilisateur the modifUtilisateur to set
	 */
	public void setModifUtilisateur(Utilisateur modifUtilisateur) {
		this.modifUtilisateur = modifUtilisateur;
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

	/**
	 * @return the mdpActuel
	 */
	public String getMdpActuel() {
		return mdpActuel;
	}

	/**
	 * @param mdpActuel the mdpActuel to set
	 */
	public void setMdpActuel(String mdpActuel) {
		this.mdpActuel = mdpActuel;
	}

	/**
	 * @return the messagePseudo
	 */
	public String getMessagePseudo() {
		return messagePseudo;
	}

	/**
	 * @param messagePseudo the messagePseudo to set
	 */
	public void setMessagePseudo(String messagePseudo) {
		this.messagePseudo = messagePseudo;
	}

	@Override
	public String toString() {
		return "ModifierProfilModel [modifUtilisateur=" + modifUtilisateur + ", confirmation=" + confirmation
				+ ", mdpActuel=" + mdpActuel + ", messagePseudo=" + messagePseudo + "]";
	}

}
