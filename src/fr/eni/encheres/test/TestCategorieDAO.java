/**
 * 
 */
package fr.eni.encheres.test;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.categorie.CategorieDALException;
import fr.eni.encheres.dal.categorie.CategorieDAO;

/**
 * @author ramon
 *
 */
public class TestCategorieDAO {
    private static CategorieDAO daoCategories = DAOFactory.getCategorieDAO();
    /**
     * @param args
     * @throws CategorieDALException 
     */
    public static void main(String[] args) throws CategorieDALException {
        //insert
        Categorie cat1 = new Categorie("Informatique");
        Categorie cat2 = new Categorie("Sport");
        Categorie cat3 = new Categorie("Ameublement");
        Categorie cat4 = new Categorie("Vetement");
//        daoCategories.insert(cat1);
//        daoCategories.insert(cat2);
//        daoCategories.insert(cat3);
//        daoCategories.insert(cat4);
        
        //findById
//        System.out.println(daoCategories.findById(cat1.getNoCategorie()));
//        System.out.println(daoCategories.findById(cat2.getNoCategorie()));
//        System.out.println(daoCategories.findById(cat3.getNoCategorie()));
//        System.out.println(daoCategories.findById(cat4.getNoCategorie()));

        //findByLibelle
        Categorie info = daoCategories.findByLibelle("informatique");
        Categorie sport = daoCategories.findByLibelle("sport");
        Categorie ameub = daoCategories.findByLibelle("ameublement");
        Categorie vetem = daoCategories.findByLibelle("vetement");
//        System.out.println(info);
//        System.out.println(sport);
//        System.out.println(ameub);
//        System.out.println(vetem);
        
        //showAll
        List<Categorie> list = daoCategories.showAll();
          
        for (Categorie cat : list) {
            System.out.println(cat.toString());
        }

    }

}
