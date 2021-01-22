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
        Utilisateur user1 = new Utilisateur("ramo", "Rusanu", "Ramona", "ramona.rusanu2020@campus-eni.fr", "123456789", "1 Rue du Port", "29000", "Quimper", "29000", 5000, false);
        Utilisateur user2 = new Utilisateur("mhamed", "Ammari", "M'hamed", "mhamed.ammari2020@campus-eni.fr", "123456789", "2 Rue du Port", "29000", "Quimper", "29000", 5000, false);
        Utilisateur user3 = new Utilisateur("melvyn", "Le Yoncour", "Melvyn", "melvyn.leyoncour2020@campus-eni.fr", "123456789", "3 Rue du Port", "29000", "Quimper", "29000", 5000, false);
//        Utilisateur user4 = new Utilisateur("furchert", "user", "four", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        user1 = daoUsers.insert(user1);
        user2 =  daoUsers.insert(user2);
        user3 = daoUsers.insert(user3);

//        user4 = daoUsers.insert(user4);
        
        Categorie cat1 = new Categorie("informatique");
        Categorie cat2 = new Categorie("sport&losirs");
        Categorie cat3 = new Categorie("ameublement");
        Categorie cat4 = new Categorie("vêtement");
        cat1 = daoCategories.insert(cat1);
        cat2 = daoCategories.insert(cat2);
        cat3 = daoCategories.insert(cat3);
        cat4 = daoCategories.insert(cat4);
        
        ArticleVendu art1 = new ArticleVendu("PC Gamer", "HP PC de bureau Pavilion Gaming - Intel Core i5-9400 - RAM 16Go - 128Go SSD + 1To HDD - GTX1660Ti 6Go - Windows 10",
        		LocalDate.of(2021, 01, 25), LocalDate.of(2021, 01, 31), 700, null, user1, cat1);
        ArticleVendu art2 = new ArticleVendu("Souris Sans Fil", "Souris Sans Fil 2.4G, VicTsing 2400 CPI Souris Optique Mobile avec Récepteur Nano USB 6 Boutons 2400 DPI"
        		+ " (5 Niveaux Réglables)", LocalDate.of(2021, 01, 01), LocalDate.of(2021, 02, 05), 42, null, user1, cat1);
        ArticleVendu art3 = new ArticleVendu("Vélo électrique Samebike", "Vélo électrique Samebike LO26 48V 500w 21 vitesses pliable ebike 10ah e bike"
        		+ " VTT Vélo assistance électrique", LocalDate.of(2021, 01, 23), LocalDate.of(2021, 03, 13), 845, null, user2, cat2);
        ArticleVendu art4 = new ArticleVendu("Armoire de chambre", "style contemporain décor chêne cendré clair - L 170,3 cm",
        		LocalDate.of(2020, 12, 20), LocalDate.of(2021, 01, 31), 320, null, user3, cat3);
        ArticleVendu art5 = new ArticleVendu("Montre Mécanique or", "Montre Homme Automatique Montre Mécanique or vintage homme Montre Top Marque De Luxe",
        		LocalDate.of(2020, 10, 01), LocalDate.of(2021, 04, 30), 6412, null, user2, cat4);
        ArticleVendu art6 = new ArticleVendu("EMPORIO ARMANI Montre", "Montre Quartz AR2448 - Homme", LocalDate.of(2021, 01, 01), LocalDate.of(2021, 01, 05), 378, 641, user3, cat4);
        ArticleVendu art7 = new ArticleVendu("Montre de Poche mécanique", "Montre de Poche mécanique à gousset Hommes cadeau spéciale Rétro"
        		+ " squelette Conception à 12 petites fenêtres avec Chaîne Boîte Cadeau", LocalDate.of(2020, 11, 25), LocalDate.of(2021, 01, 21), 2500, 7456, user2, cat4);
        ArticleVendu art8 = new ArticleVendu("Sac à Main Femme", "Sac à Bandoulière Elégant Portefeuille Paquet de Cartes en PU Cuir Noir", LocalDate.of(2021, 01, 27),
        		LocalDate.of(2021, 02, 15), 140, null, user3, cat4);

        //insert
        daoArticles.insert(art1);
        daoArticles.insert(art2);
        daoArticles.insert(art3);
        daoArticles.insert(art4);
        daoArticles.insert(art5);
        daoArticles.insert(art6);
        daoArticles.insert(art7);
        daoArticles.insert(art8);
        
        Retrait retrait1 = new Retrait("1 Rue des Hortensias", "Paris", "95000");
        retrait1.setArticle(art1);
        
        Retrait retrait2 = new Retrait("2 Rue des Perroquets", "Lorient", "56000");
        retrait2.setArticle(art2);
        
        Retrait retrait3 = new Retrait("3 Rue des Duves", "Quimper", "29000");
        retrait3.setArticle(art3);
        
        Retrait retrait4 = new Retrait("4 Rue du Lycée", "Lyon", "45000");
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
