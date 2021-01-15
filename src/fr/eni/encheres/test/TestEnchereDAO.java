/**
 * 
 */
package fr.eni.encheres.test;

import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.article.ArticleVenduDALException;
import fr.eni.encheres.dal.article.ArticleVenduDAO;
import fr.eni.encheres.dal.categorie.CategorieDALException;
import fr.eni.encheres.dal.categorie.CategorieDAO;
import fr.eni.encheres.dal.enchere.EnchereDALException;
import fr.eni.encheres.dal.enchere.EnchereDAO;
import fr.eni.encheres.dal.user.UserDALException;
import fr.eni.encheres.dal.user.UserDAO;

/**
 * @author ramon
 *
 */
public class TestEnchereDAO {
    private static ArticleVenduDAO daoArticles = DAOFactory.getArticleDAO();
    private static UserDAO daoUsers = DAOFactory.getUserDAO();
    private static EnchereDAO daoEncheres = DAOFactory.getEnchereDAO();
    private static CategorieDAO daoCategories = DAOFactory.getCategorieDAO();
    
    /**
     * @param args
     * @throws CategorieDALException 
     * @throws UserDALException 
     * @throws ArticleVenduDALException 
     * @throws EnchereDALException 
     */
    public static void main(String[] args) throws CategorieDALException, UserDALException, ArticleVenduDALException, EnchereDALException {
        Utilisateur user1 = new Utilisateur("rr19", "user", "one", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user2 = new Utilisateur("tt20", "user", "two", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user3 = new Utilisateur("ss21", "user", "three", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user4 = new Utilisateur("yy22", "user", "four", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
//        user1 = daoUsers.insert(user1);
//        user2 =  daoUsers.insert(user2);
//        user3 = daoUsers.insert(user3);
//        user4 = daoUsers.insert(user4);
        
        Categorie cat1 = new Categorie("informatique");
        Categorie cat2 = new Categorie("sport");
        Categorie cat3 = new Categorie("ameublement");
//        cat1 = daoCategories.insert(cat1);
//        cat2 = daoCategories.insert(cat2);
//        cat3 = daoCategories.insert(cat3);
        
        ArticleVendu art1 = new ArticleVendu("PC Gamer", "bla bla bla pc gamer bla bla", LocalDate.now(), LocalDate.now(), 55, null, user1, cat1);
        ArticleVendu art2 = new ArticleVendu("Mouse", "mouse Microsoft", LocalDate.now(), LocalDate.now(), 42, null, user1, cat1);
        ArticleVendu art3 = new ArticleVendu("Vélo", "vélo b-twin en super bon état", LocalDate.now(), LocalDate.now(), 299, null, user2, cat2);
        ArticleVendu art4 = new ArticleVendu("Armoir bois", "armoir bois chêne massif", LocalDate.now(), LocalDate.now(), 741, null, user3, cat3);
//        art1 = daoArticles.insert(art1);
//        art2 = daoArticles.insert(art2);
//        art3 = daoArticles.insert(art3);
//        art4 = daoArticles.insert(art4);
        
        Enchere enchere1 = new Enchere(LocalDate.now(), 200);
        enchere1.setArticle(art1);
        enchere1.setUtilisateur(user1);
        
        Enchere enchere2 = new Enchere(LocalDate.now(), 200);
        enchere2.setArticle(art2);
        enchere2.setUtilisateur(user2);
        
        Enchere enchere3 = new Enchere(LocalDate.now(), 200);
        enchere3.setArticle(art3);
        enchere3.setUtilisateur(user3);
        
        Enchere enchere4 = new Enchere(LocalDate.now(), 200);
        enchere4.setArticle(art4);
        enchere4.setUtilisateur(user4);
        
        //insert
//        daoEncheres.insert(enchere1);
//        daoEncheres.insert(enchere2);
//        daoEncheres.insert(enchere3);
//        daoEncheres.insert(enchere4);
        
        //getAllByUser
//        List<Enchere> list = daoEncheres.getAllByUser(user1.getNoUtilisateur());
//        for (Enchere ench : list) {
//            System.out.println(ench.toString());
//        }
        
        //show all
        System.out.println(daoEncheres.showAll());
        
    }

}
