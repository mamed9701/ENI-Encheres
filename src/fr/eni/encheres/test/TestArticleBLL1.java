package fr.eni.encheres.test;

import java.time.LocalDate;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.enchere.EnchereManager;
import fr.eni.encheres.bll.enchere.EnchereManagerSingl;
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

public class TestArticleBLL1 {
	
	private static EnchereManager manager = EnchereManagerSingl.getInstance();
    private static UserDAO daoUsers = DAOFactory.getUserDAO();
    private static CategorieDAO daoCategories = DAOFactory.getCategorieDAO();
    private static ArticleVenduDAO daoArticleVendu = DAOFactory.getArticleDAO();

	public static void main(String[] args) throws UserDALException, CategorieDALException, BLLException, ArticleVenduDALException {
		
		 Utilisateur user1 = daoUsers.findById(1);
	     Categorie categorie = daoCategories.findByLibelle("informatique");
	     
	     
	     ArticleVendu article1 = new ArticleVendu("Montre en or", "jolie montre en or jaune", LocalDate.now(), LocalDate.now(), 1500, 2555, user1, categorie);
	     ArticleVendu article2 = new ArticleVendu("Clavier mécanique", "Clavier mécanique pour pc gamer", LocalDate.now(), LocalDate.now(), 340, 750, user1, categorie);
	     
	     manager.ajouterArticle(article2);
	     System.out.println(daoArticleVendu.selectById(2));

	}

}
