/**
 * 
 */
package fr.eni.encheres.dal.user;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;

/**
 * @author ramon
 *
 */
public interface UserDAO {
    /**
     * Insertion d'un nouvel utilisateur dans la base de données
     * 
     * @param user - objet de type Utilisateur
     * @return L'utilisateur inséré 
     * @throws UserDALException
     */
    public Utilisateur insert(Utilisateur user) throws UserDALException;
    
    /**
     * Afficher un utilisateur
     * 
     * @param id
     * @return l'utilisateur
     * @throws UserDALException
     */
    public Utilisateur findById(Integer id) throws UserDALException;
    
    /**
     * Modifier un utilisateur
     * 
     * @param id
     * @return l'utilisateur modifié
     * @throws UserDALException
     */
    public Utilisateur edit(Integer id) throws UserDALException;
    
    /**
     * Supprimer un utilisateur
     * 
     * @param id
     * @throws UserDALException
     */
    public void delete(Integer id) throws UserDALException;
    
    /**
     * Trouver un utilisateur par son nom
     * 
     * @param username
     * @return
     * @throws UserDALException
     */
    public Utilisateur findByUsername(String username) throws UserDALException;
    
    /**
     * Sélectionner tous les utilisateurs (Administration)
     * 
     * @return
     * @throws UserDALException
     */
    public List<Utilisateur> showAll() throws UserDALException;
    
}
