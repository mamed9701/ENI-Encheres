package fr.eni.encheres.ihm.afficherEncheres;

import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;

public class AfficherEncheresModel {
	private String filtre;
	private List<Categorie> listCategories = new ArrayList<>();
	private List<Enchere> listEncheres = new ArrayList<>();

	/**
	 * 
	 */
	public AfficherEncheresModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param filtre
	 * @param listCategories
	 */
	public AfficherEncheresModel(String filtre, List<Categorie> listCategories) {
		super();
		this.filtre = filtre;
		this.listCategories = listCategories;
	}

	/**
	 * @return the filtre
	 */
	public String getFiltre() {
		return filtre;
	}

	/**
	 * @param filtre the filtre to set
	 */
	public void setFiltre(String filtre) {
		this.filtre = filtre;
	}

	/**
	 * @return the listCategories
	 */
	public List<Categorie> getListCategories() {
		return listCategories;
	}

	/**
	 * @param listCategories the listCategories to set
	 */
	public void setListCategories(List<Categorie> listCategories) {
		this.listCategories = listCategories;
	}

	/**
	 * @return the listEncheres
	 */
	public List<Enchere> getListEncheres() {
		return listEncheres;
	}

	/**
	 * @param listEncheres the listEncheres to set
	 */
	public void setListEncheres(List<Enchere> listEncheres) {
		this.listEncheres = listEncheres;
	}

	@Override
	public String toString() {
		return "AfficherEncheresModel [filtre=" + filtre + ", listCategories=" + listCategories + ", listEncheres="
				+ listEncheres + "]";
	}

}
