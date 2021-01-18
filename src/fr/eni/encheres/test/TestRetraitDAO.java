/**
 * 
 */
package fr.eni.encheres.test;

import java.time.LocalDate;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.article.ArticleVenduDALException;
import fr.eni.encheres.dal.article.ArticleVenduDAO;
import fr.eni.encheres.dal.categorie.CategorieDALException;
import fr.eni.encheres.dal.categorie.CategorieDAO;
import fr.eni.encheres.dal.retrait.RetraitDALException;
import fr.eni.encheres.dal.retrait.RetraitDAO;
import fr.eni.encheres.dal.user.UserDALException;
import fr.eni.encheres.dal.user.UserDAO;

/**
 * @author ramon
 *
 */
public class TestRetraitDAO {
    private static ArticleVenduDAO daoArticles = DAOFactory.getArticleDAO();
    private static UserDAO daoUsers = DAOFactory.getUserDAO();
    private static CategorieDAO daoCategories = DAOFactory.getCategorieDAO();
    private static RetraitDAO daoRetraits = DAOFactory.getRetraitDAO();
    /**
     * @param args
     * @throws RetraitDALException 
     * @throws UserDALException 
     * @throws CategorieDALException 
     * @throws ArticleVenduDALException 
     */
    public static void main(String[] args) throws RetraitDALException, UserDALException, CategorieDALException, ArticleVenduDALException {
        Utilisateur user1 = new Utilisateur("rr19", "user", "one", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user2 = new Utilisateur("tt20", "user", "two", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user3 = new Utilisateur("ss21", "user", "three", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user4 = new Utilisateur("yy22", "user", "four", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        user1 = daoUsers.insert(user1);
        user2 =  daoUsers.insert(user2);
        user3 = daoUsers.insert(user3);
        user4 = daoUsers.insert(user4);
        
        Categorie cat1 = new Categorie("informatique");
        Categorie cat2 = new Categorie("sport");
        Categorie cat3 = new Categorie("ameublement");
        cat1 = daoCategories.insert(cat1);
        cat2 = daoCategories.insert(cat2);
        cat3 = daoCategories.insert(cat3);
        ArticleVendu art1 = new ArticleVendu("PC Gamer", "bla bla bla pc gamer bla bla", LocalDate.now(), LocalDate.now(), 55, null, user1, cat1);
        ArticleVendu art2 = new ArticleVendu("Mouse", "mouse Microsoft", LocalDate.now(), LocalDate.now(), 42, null, user1, cat1);
        ArticleVendu art3 = new ArticleVendu("Vélo", "vélo b-twin en super bon état", LocalDate.now(), LocalDate.now(), 299, null, user2, cat2);
        ArticleVendu art4 = new ArticleVendu("Armoir bois", "armoir bois chêne massif", LocalDate.now(), LocalDate.now(), 741, null, user3, cat3);
        art1 = daoArticles.insert(art1);
        art2 = daoArticles.insert(art2);
        art3 = daoArticles.insert(art3);
        art4 = daoArticles.insert(art4);
        
        Retrait retrait1 = new Retrait("1 rue des hortensias", "Paris", "95000");
        retrait1.setArticle(art1);
        
        Retrait retrait2 = new Retrait("2 rue des perroquets", "Lille", "84000");
        retrait2.setArticle(art2);
        
        Retrait retrait3 = new Retrait("3 rue des duves", "Quimper", "29000");
        retrait3.setArticle(art3);
        
        Retrait retrait4 = new Retrait("4 rue du lycée", "Lyon", "45000");
        retrait4.setArticle(art4);
        //insert
        daoRetraits.insert(retrait1);
        daoRetraits.insert(retrait2);
        daoRetraits.insert(retrait3);
        daoRetraits.insert(retrait4);
        //delete
//        daoRetraits.delete(85);
//        daoRetraits.delete(86);
//        daoRetraits.delete(87);
//        daoRetraits.delete(88);
        //showAll
        System.out.println(daoRetraits.showAll());
        
    }

}
