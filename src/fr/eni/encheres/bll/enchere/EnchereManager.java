package fr.eni.encheres.bll.enchere;

import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;


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
     * Trouver un article par id
     * 
     * @param id integer identifiant de l'article
     * @return L'article trouvé
     * @throws BLLException
     */
    public ArticleVendu getArticleParId(Integer id) throws BLLException;
    
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
     * Récupérer toutes les articles par date de début
     * 
     * @return Une liste de toutes les articles par date début
     * @throws BLLException
     */
    public List<ArticleVendu> getArticlesParDateDebut(LocalDate debut) throws BLLException;
    
    /**
     * Récupérer toutes les articles
     * 
     * @return Une liste de toutes les articles
     * @throws BLLException
     */
    public List<ArticleVendu> getAllArticles() throws BLLException;
    
    /**
     * Récupérer toutes les enchères d'un utilisateur
     * 
     * @param id - l'identifiant de l'utilisateur
     * @return La liste des enchères d'un utilisateur
     * @throws BLLException
     */
    public List<Enchere> getEncheresByUser(Integer id) throws BLLException;
     
    /**
     * Récupérer toutes les articles d'un utilisateur
     * 
     * @param id - l'identifiant de l'utilisateur
     * @return La liste des enchères d'un utilisateur
     * @throws BLLException
     */
    public List<ArticleVendu> getArticlesByUser(Integer id) throws BLLException;
    
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
    
    /**
     * Récupérer toutes les catégories
     * 
     * @return Une liste de toutes les catégories
     * @throws BLLException
     */
    public List<Categorie> getAllCategories() throws BLLException;
    
    /**
     * Trouver une catégorie par libelle
     * 
     * @return La categorie correspondante 
     * @throws BLLException
     */
    public Categorie trouverParLibelle(String libelle) throws BLLException;

    /**
     * Ajouter un nouveau retrait dans la bdd
     * 
     * @throws BLLException
     */
	public void ajoutRetrait(Retrait retrait) throws BLLException;
    
    
    
}
