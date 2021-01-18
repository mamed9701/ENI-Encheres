/**
 * 
 */
package fr.eni.encheres.test;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.user.UserManager;
import fr.eni.encheres.bll.user.UserManagerSingl;

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

        System.out.println(manager.connexion("rr19", "123456"));


    }

}
