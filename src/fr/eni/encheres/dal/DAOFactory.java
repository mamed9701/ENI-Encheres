/**
 * 
 */
package fr.eni.encheres.dal;

import fr.eni.encheres.dal.categorie.CategorieDAO;
import fr.eni.encheres.dal.categorie.CategorieDAOImpl;
import fr.eni.encheres.dal.enchere.EnchereDAO;
import fr.eni.encheres.dal.enchere.EnchereDAOImpl;
import fr.eni.encheres.dal.retrait.RetraitDAO;
import fr.eni.encheres.dal.retrait.RetraitDAOImpl;
import fr.eni.encheres.dal.user.UserDAO;
import fr.eni.encheres.dal.user.UserDAOImpl;

/**
 * @author ramon
 *
 */
public class DAOFactory {

    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }
    
    public static RetraitDAO getRetraitDAO() {
        return new RetraitDAOImpl();
    }
    
    public static CategorieDAO getCategorieDAO() {
        return new CategorieDAOImpl();
    }
    
    public static EnchereDAO getEnchereDAO() {
        return new EnchereDAOImpl();
    }

}
