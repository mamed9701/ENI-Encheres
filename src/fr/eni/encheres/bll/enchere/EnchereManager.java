package fr.eni.encheres.bll.enchere;

import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;


/**
 * Classe de gestion des enchères
 * 
 * @author ramon
 *
 */
public interface EnchereManager {
    
    /**
     * Mettre un article en vente
     * 
     * @param article - objet de type ArticleVendu
     * @return L'article créé
     * @throws BLLException
     */
    public ArticleVendu ajouterArticle(ArticleVendu article) throws BLLException;
    
    /**
     * Faire une enchère sur un article
     * 
     * @param article - un objet de type ArticleVendu
     * @return L'enchère créée
     * @throws BLLException
     */
    public Enchere encherir(ArticleVendu article, Enchere enchere) throws BLLException;
    
    /**
     * Récupérer toutes les enchères
     * 
     * @return Une liste de toutes les enchères
     * @throws BLLException
     */
    public List<Enchere> getAllEncheres() throws BLLException;
    
    /**
     * Récupérer toutes les enchères d'un utilisateur
     * 
     * @param id - l'identifiant de l'utilisateur
     * @return La liste des enchères d'un utilisateur
     * @throws BLLException
     */
    public List<Enchere> getEncheresByUser(Integer id) throws BLLException;
     
    /**
     * Remporter une vente
     * 
     * @param article - un objet de type ArticleVendu
     * @return L'article acquis
     * @throws BLLException
     */
    public ArticleVendu acquerir(ArticleVendu article) throws BLLException;
    
    /**
     * Afficher les détails d'une enchère
     * 
     * @param id - l'identifiant de l'enchère à afficher
     * @return L'enchère à afficher
     * @throws BLLException
     */
    public Enchere afficherEnchere(Integer id) throws BLLException;
    
}
