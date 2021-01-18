package fr.eni.encheres.bll.enchere;

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

	ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleDAO();
	UserDAO utilisateurDAO = DAOFactory.getUserDAO();
	EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
	CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();

	@Override
	public ArticleVendu ajouterArticle(ArticleVendu article) throws BLLException {
		ArticleVendu result = null;
		try {
			result = articleVenduDAO.insert(article);
		} catch (ArticleVenduDALException e) {
			e.printStackTrace();
			throw new BLLException("Echec de l'ajout d'un article");

		}
		return result;
	}

	Integer idUtilisPreced = null;
	
	@Override
	public Enchere encherir(ArticleVendu article, Enchere enchere) throws BLLException {
		Utilisateur user = enchere.getUtilisateur();
		
		Integer credit = user.getCredit();
		
		if (enchere.getMontantEnchere() < credit) {
			if (article.getPrixVente() == null) {
				if (enchere.getMontantEnchere() > article.getMiseAPrix()) {
					article.setPrixVente(enchere.getMontantEnchere());
				} else {
					throw new BLLException("Le prix que vous propsez n'est pas suffisant !");
			
				}
			} else {
				while (enchere.getMontantEnchere() > article.getPrixVente()) {
					idUtilisPreced = user.getNoUtilisateur();
					article.setPrixVente(enchere.getMontantEnchere());
				}
			}
			credit -= enchere.getMontantEnchere();

			user.setCredit(credit);
			try {
				
				utilisateurDAO.edit(user);
			} catch (UserDALException e) {
				e.printStackTrace();
			}

			//verifier si l'id de l'utilisateur courant est dans la table encheres et si il est on fait update()
			
			
			
			
			//et update de la table utilisateur si il est surpassé
			try { 
				enchereDAO.insert(enchere);
			} catch (EnchereDALException e) {
				e.printStackTrace();
			}
			
			
			
			// Le meilleur enrechisseur précedent s'il existe est re-crédité de son offre
//			utilisateurDAO.findById(idUtilisPreced);
			
			
		} else {
			// error vos n'avez pas assez credit
		}

		return enchere;
	}

	@Override
	public List<Enchere> getAllEncheres() throws BLLException {
		
		 try {
			enchereDAO.showAll();
		} catch (EnchereDALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		
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

	    Enchere enchere = null;
		try {
            enchere = enchereDAO.findById(id);
        } catch (EnchereDALException e) {
            e.printStackTrace();
        }
		
		return enchere;

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
