/**
 * 
 */
package fr.eni.encheres.bll.user;

/**
 * @author ramon
 *
 */
public class UserManagerSingl {
private static UserManager _instance;
    
    public static UserManager getInstance() {
        if (_instance == null) {
            _instance = new UserManagerImpl();
        }
        return _instance;
    }
}
