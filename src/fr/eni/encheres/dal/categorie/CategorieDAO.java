/**
 * 
 */
package fr.eni.encheres.dal.categorie;

import java.util.List;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.user.UserDALException;

/**
 * @author ramon
 *
 */
public interface CategorieDAO {
    /**
     * Insertion d'une nouvelle catégorie dans la base de données
     * 
     * @param categorie - objet de type Categorie
     * @return La catégorie insérée 
     * @throws CategorieDALException
     */
    public Categorie insert(Categorie categorie) throws CategorieDALException;
    
    /**
     * Trouver une catégorie par identifiant
     * 
     * @param id
     * @return un objet de type Categorie
     * @throws CategorieDALException
     */
    public Categorie findById(Integer id) throws CategorieDALException;
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
