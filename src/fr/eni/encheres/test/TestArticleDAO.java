/**
 * 
 */
package fr.eni.encheres.test;

import java.time.LocalDate;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.article.ArticleVenduDALException;
import fr.eni.encheres.dal.article.ArticleVenduDAO;
import fr.eni.encheres.dal.categorie.CategorieDALException;
import fr.eni.encheres.dal.categorie.CategorieDAO;
import fr.eni.encheres.dal.user.UserDALException;
import fr.eni.encheres.dal.user.UserDAO;

/**
 * @author ramon
 *
 */
public class TestArticleDAO {
    private static ArticleVenduDAO daoArticles = DAOFactory.getArticleDAO();
    private static UserDAO daoUsers = DAOFactory.getUserDAO();
    private static CategorieDAO daoCategories = DAOFactory.getCategorieDAO();
    /**
     * @param args
     * @throws ArticleVenduDALException 
     * @throws UserDALException 
     * @throws CategorieDALException 
     */
    public static void main(String[] args) throws ArticleVenduDALException, UserDALException, CategorieDALException {
        Utilisateur user1 = daoUsers.findById(32);
        Categorie categorie = daoCategories.findByLibelle("informatique");
        
        ArticleVendu art1 = new ArticleVendu("article 1", "description article 1", LocalDate.now(), LocalDate.now(), 10, 25, user1, categorie);
        ArticleVendu art2 = new ArticleVendu("article 2", "description article 2", LocalDate.now(), LocalDate.now(), 10, 25, user1, categorie);
        ArticleVendu art3 = new ArticleVendu("article 3", "description article 3", LocalDate.now(), LocalDate.now(), 10, 25, user1, categorie);
        ArticleVendu art4 = new ArticleVendu("article 4", "description article 4", LocalDate.now(), LocalDate.now(), 10, 25, user1, categorie);
        ArticleVendu art5 = new ArticleVendu("Montre en or", "jolie montre en or jaune", LocalDate.now(), LocalDate.now(), 1500, 2555, user1, categorie);

        //insert
//        daoArticles.insert(art1);
//        daoArticles.insert(art2);
//        daoArticles.insert(art3);
//        daoArticles.insert(art4);
        daoArticles.insert(art5);
        //delete
//        daoArticles.delete(10);
        //selectByNom
        daoArticles.selectByNom("montre");
        
    }

}
