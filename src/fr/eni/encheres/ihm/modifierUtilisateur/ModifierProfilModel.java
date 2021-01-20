package fr.eni.encheres.ihm.modifierUtilisateur;

import fr.eni.encheres.bo.Utilisateur;

public class ModifierProfilModel {

	private Utilisateur utilisateur;

	/**
	 * 
	 */
	public ModifierProfilModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param utilisateur
	 * @param confirmation
	 * @param nmdp
	 */
	public ModifierProfilModel(Utilisateur utilisateur) {
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

		return "ModifierProfilModel [utilisateur=" + utilisateur + "]";
	}

}
