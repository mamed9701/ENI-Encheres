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
     * @return une liste des toutes les categories
     * @throws CategorieDALException
     */
    public List<Categorie> showAll() throws CategorieDALException;
}
