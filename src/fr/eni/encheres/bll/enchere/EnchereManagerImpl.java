package fr.eni.encheres.bll.enchere;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bll.BLLException;
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



public class EnchereManagerImpl implements EnchereManager {

    @Override
    public ArticleVendu ajouterArticle(ArticleVendu article) throws BLLException {
        return null;
    }
    @Override
    public Enchere encherir(ArticleVendu article) throws BLLException {
        return null;
    }

    @Override
    public List<Enchere> getAllEncheres() throws BLLException {
        return null;
    }

    @Override
    public List<Enchere> getEncheresByUser(Integer id) throws BLLException {
        return null;
    }

    @Override
    public ArticleVendu acquerir(ArticleVendu article) throws BLLException {
        return null;
    }

    @Override
    public Enchere afficherEnchere(Integer id) throws BLLException {
        return null;
    }



    @Override
    public List<Categorie> getAllCategories() throws BLLException {
        List<Categorie> categories = new ArrayList<>();

        try {
            categories = categorieDAO.showAll();
        } catch (CategorieDALException e) {
            e.printStackTrace();
        }

        return categories;
    }

}
