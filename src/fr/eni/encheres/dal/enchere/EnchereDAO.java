/**
 * 
 */
package fr.eni.encheres.dal.enchere;

import java.util.List;

import fr.eni.encheres.bo.Enchere;

/**
 * @author ramon
 *
 */
public interface EnchereDAO {
    /**
     * Création d'une nouvelle enchère
     * 
     * @param enchere - objet de type Enchere
     * @return L'enchère inséré 
     * @throws EnchereDALException
     */
    public Enchere insert(Enchere enchere) throws EnchereDALException;
    
    /**
     * Afficher toutes les enchères d'un utilisateur
     * 
     * @param id - l'identifian de l'utilisateur
     * @return La liste des enchères de l'utilisateur
     * @throws EnchereDALException
     */
    public List<Enchere> getAllByUser(Integer id) throws EnchereDALException;
    
    /**
     * Sélectionner tous les enchères
     * 
     * @return La liste des toutes les enchères
     * @throws EnchereDALException
     */
    public List<Enchere> showAll() throws EnchereDALException;
    
    /**
     * Mise à jour d'une enchère
     * 
     * @param enchere - objet de type Enchere
     * @return L'enchère modifiée 
     * @throws EnchereDALException
     */
    public Enchere update(Enchere enchere) throws EnchereDALException;
}
