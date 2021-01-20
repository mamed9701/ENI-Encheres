/**
 * 
 */
package fr.eni.encheres.test;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.user.UserManager;
import fr.eni.encheres.bll.user.UserManagerSingl;
import fr.eni.encheres.bo.Utilisateur;

/**
 * @author ramon
 *
 */
public class TestUserBLL {
    private static UserManager manager = UserManagerSingl.getInstance();
    /**
     * @param args
     * @throws BLLException 
     */
    public static void main(String[] args) throws BLLException {
        Utilisateur user = new Utilisateur("test", "test", "test", "test@test.com", "123456", "1 rue du test", "123456", "Test", "1111", 0, false);
        System.out.println(manager.inscription(user));

//        System.out.println(manager.connexion("test", "123456"));

    }

}
