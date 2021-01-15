/**
 * 
 */
package fr.eni.encheres.test;

import java.time.LocalDate;
import java.util.List;

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
        Utilisateur user1 = new Utilisateur("rr19", "user", "one", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user2 = new Utilisateur("tt20", "user", "two", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user3 = new Utilisateur("ss21", "user", "three", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user4 = new Utilisateur("yy22", "user", "four", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        //insert
//        daoUsers.insert(user1);
//        daoUsers.insert(user2);
//        daoUsers.insert(user3);
//        daoUsers.insert(user4);
        
        Categorie cat1 = new Categorie("informatique");
        Categorie cat2 = new Categorie("sport");
        Categorie cat3 = new Categorie("ameublement");
        Categorie cat4 = new Categorie("vetement");
//        daoCategories.insert(cat1);
//        daoCategories.insert(cat2);
//        daoCategories.insert(cat3);
//        daoCategories.insert(cat4);
        
        Categorie info = daoCategories.findByLibelle("informatique");
        Categorie sport = daoCategories.findByLibelle("sport");
        Categorie ameub = daoCategories.findByLibelle("ameublement");
        Categorie vetem = daoCategories.findByLibelle("vetement");
        
        ArticleVendu art1 = new ArticleVendu("PC Gamer", "bla bla bla pc gamer bla bla", LocalDate.now(), LocalDate.now(), 55, null, user1, info);
        ArticleVendu art2 = new ArticleVendu("Mouse", "mouse Microsoft", LocalDate.now(), LocalDate.now(), 42, null, user1, info);
        ArticleVendu art3 = new ArticleVendu("Vélo", "vélo b-twin en super bon état", LocalDate.now(), LocalDate.now(), 299, null, user2, sport);
        ArticleVendu art4 = new ArticleVendu("Armoir bois", "armoir bois chêne massif", LocalDate.now(), LocalDate.now(), 741, null, user3, ameub);
        ArticleVendu art5 = new ArticleVendu("Montre en or", "jolie montre en or jaune", LocalDate.now(), LocalDate.now(), 1500, null, user4, vetem);
        ArticleVendu art6 = new ArticleVendu("Montre en argent", "jolie montre en argent", LocalDate.now(), LocalDate.now(), 378, 641, user2, vetem);
        ArticleVendu art7 = new ArticleVendu("Montre de poche", "jolie montre de poche", LocalDate.now(), LocalDate.now(), 1500, 2555, user4, vetem);
        ArticleVendu art8 = new ArticleVendu("Sac à main", "sac à main en cuir", LocalDate.now(), LocalDate.now(), 1500, 2555, user3, vetem);

        //insert
//        daoArticles.insert(art1);
//        daoArticles.insert(art2);
//        daoArticles.insert(art3);
//        daoArticles.insert(art4);
//        daoArticles.insert(art5);
//        daoArticles.insert(art6);
//        daoArticles.insert(art7);
//        daoArticles.insert(art8);
        
        //delete
//        daoArticles.delete(10);
        
        //selectByNom
//        List<ArticleVendu> list = daoArticles.selectByNom("montre");
//        
//        for (ArticleVendu art : list) {
//            System.out.println(art.toString());
//        }
        
        //selectById
//        System.out.println(daoArticles.selectById(16));
        
        //update
//        art8 = daoArticles.update(art5);
//        System.out.println(art8);
        
        //selectByNomAndCategorie
//        System.out.println(daoArticles.selectByNomAndCateg("montre", vetem.getNoCategorie()));
        
        //selectByCategorie
        System.out.println(daoArticles.selectByCategorie(14));
        
    }

}
