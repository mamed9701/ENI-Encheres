/**
 * 
 */
package fr.eni.encheres.dal;

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

}
