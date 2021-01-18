package fr.eni.encheres.bll.user;


import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Classe de gestion des utilisateurs
 * 
 * @author ramon
 *
 */
public interface UserManager {
    /**
     * Création d'un nouveau compte utilisateur
     * 
     * @param user - objet de type Utilisateur
     * @return L'utilisateur créé
     * @throws BLLException
     */
    public Utilisateur inscription(Utilisateur user) throws BLLException;
    
    /**
     * Connexion d'un utilisateur
     * 
     * @param user - objet de type Utilisateur
     * @return L'utilisateur connecté
     * @throws BLLException
     */
    public Utilisateur connexion(String pseudo, String mdp) throws BLLException;
    
    /**
     * Afficher le profil d'un utilisateur
     * 
     * @param id - l'identifiant de l'utilisateur à afficher
     * @return L'utilisateur à afficher
     * @throws BLLException
     */
    public Utilisateur afficherUtilisateur(Integer id) throws BLLException;
    
    /**
     * Modifier les informations d'un utilisateur
     * 
     * @param id - l'identifiant de l'utilisateur à modifier
     * @return L'utilisateur modifié
     * @throws BLLException
     */
    public Utilisateur modifierUtilisateur(Utilisateur user) throws BLLException;
    
    /**
     * Supprimer un compte utilisateur
     * 
     * @param id - l'identifiant de l'utilisateur à supprimer
     * @throws BLLException
     */
    public void supprimerUtilisateur(Integer id) throws BLLException;
    
}
