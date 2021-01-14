/**
 * 
 */
package fr.eni.encheres.bll.enchere;

/**
 * @author ramon
 *
 */
public class EnchereManagerSingl {
    private static EnchereManager _instance;
    
    public static EnchereManager getInstance() {
        if (_instance == null) {
            _instance = new EnchereManagerImpl();
        }
        return _instance;
    }
}
