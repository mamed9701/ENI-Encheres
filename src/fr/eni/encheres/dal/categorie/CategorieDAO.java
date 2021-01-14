/**
 * 
 */
package fr.eni.encheres.dal.categorie;

import java.util.List;
import fr.eni.encheres.bo.Categorie;

/**
 * @author ramon
 *
 */
public interface CategorieDAO {
    /**
     * Trouver une catégorie par libellé
     * 
     * @param libellé
     * @return un objet de type Categorie
     * @throws CategorieDALException
     */
    public Categorie findByLibelle(String libelle) throws CategorieDALException;
    /**
     * Afficher toutes les catégories
     * 
     * @return une liste des toutes les categories
     * @throws CategorieDALException
     */
    public List<Categorie> showAll() throws CategorieDALException;
}
