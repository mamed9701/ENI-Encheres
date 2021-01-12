/**
 * 
 */
package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;

/**
 * @author ramon
 *
 */
public interface EncheresManager {
    public Utilisateur seConnecter() throws EncheresException;
}
