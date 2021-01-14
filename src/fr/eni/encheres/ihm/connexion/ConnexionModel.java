package fr.eni.encheres.ihm.connexion;

public class ConnexionModel {

	private String identifiant;
	private String motDePasse;

	/**
	 * 
	 */
	public ConnexionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param identifiant
	 * @param motDePasse
	 */
	public ConnexionModel(String identifiant, String motDePasse) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}

	/**
	 * @return the identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant the identifiant to set
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "ConnexionModel [identifiant=" + identifiant + ", motDePasse=" + motDePasse + "]";
	}
	
	

}
