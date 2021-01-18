/**
 * 
 */
package fr.eni.encheres.bll.user;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.user.UserDALException;
import fr.eni.encheres.dal.user.UserDAO;

/**
 * @author ramon
 *
 */
public class UserManagerImpl implements UserManager {
	
	private UserDAO userDAO = DAOFactory.getUserDAO();
	
    @Override
    public Utilisateur inscription(Utilisateur user) throws BLLException {
    	
    	try {
    		userDAO.insert(user);
		} catch (UserDALException e) {
			throw new BLLException("Impossible d'insérer un nouvel utilisaeur");
		}
        return user;
    }

    @Override
    public Utilisateur connexion(String pseudo, String mdp) throws BLLException {
    	Utilisateur user = null;
    	
		try {
			user = userDAO.findByUsernameAndPwd(pseudo, mdp);
			
		} catch (UserDALException e) {
			throw new BLLException("L'utilisateur n'existe pas");
		}
	
		return user;
    }

    @Override
    public void deconnection(Utilisateur user) throws BLLException {
        
    }

    @Override
    public Utilisateur afficherUtilisateur(Integer id) throws BLLException {
    	Utilisateur user = null;
    	try {
    		user = userDAO.findById(id);
		} catch (UserDALException e) {
			throw new BLLException("Impossible d'afficher l'utilisaeur");
		}
        return user;
    }

    @Override
//    public Utilisateur modifierUtilisateur(Integer id) throws BLLException {
      public Utilisateur modifierUtilisateur(Utilisateur user) throws BLLException {
    	try {
			userDAO.edit(user);
		} catch (UserDALException e) {
			throw new BLLException("Impossible de modifier l'utilisaeur");
		}
        return null;
    }

    @Override
    public void supprimerUtilisateur(Integer id) throws BLLException {
        try {
			userDAO.delete(id);
		} catch (UserDALException e) {
			throw new BLLException("Impossible de supprimer l'utilisaeur");
		}
        
    }


}
