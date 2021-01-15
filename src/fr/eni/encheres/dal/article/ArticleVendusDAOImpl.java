package fr.eni.encheres.dal.article;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.categorie.CategorieDALException;
import fr.eni.encheres.dal.categorie.CategorieDAO;
import fr.eni.encheres.dal.user.UserDALException;
import fr.eni.encheres.dal.user.UserDAO;


public class ArticleVendusDAOImpl implements ArticleVenduDAO {  
    private static UserDAO daoUsers = DAOFactory.getUserDAO();
    private static CategorieDAO daoCategories = DAOFactory.getCategorieDAO();
    
	private static final String INSERT = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
	        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE articles_vendus"
	        +" set nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=?"
	        +" where no_article=?";
	private static final String DELETE = "DELETE FROM Articles_Vendus WHERE no_article = ?;";
	private static final String SELECT_ID = "SELECT * FROM Articles_Vendus WHERE no_article = ?;";
	private static final String SELECT_MOT_CLE = "SELECT * FROM Articles_Vendus WHERE nom_article LIKE ?";
	private static final String SELECT_MOT_CATEG = "SELECT * FROM Articles_Vendus WHERE nom_article LIKE ? AND no_categorie = ?;";
	private static final String SELECT_CATEGORIE = "SELECT * FROM Articles_Vendus WHERE no_categorie = ?;";

	@Override
	public ArticleVendu insert(ArticleVendu article) throws ArticleVenduDALException {
	    Utilisateur user = article.getUtilisateur();
        Categorie categorie = article.getCategorie();
        
		try( Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
		        ) {
				stmt.setString(1, article.getNomArticle());
				stmt.setString(2, article.getDescription());
				stmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
				stmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
				
				if (null != article.getMiseAPrix()) {
				    stmt.setInt(5, article.getMiseAPrix());                
                }else {
                    stmt.setNull(5, Types.NULL);   
                }
				if (null != article.getPrixVente()) {
                    stmt.setInt(6, article.getPrixVente());                    
                }else {
                    stmt.setNull(6, Types.NULL);   
                }
				stmt.setInt(7, user.getNoUtilisateur());
				stmt.setInt(8, categorie.getNoCategorie());
				
                int nbRows = stmt.executeUpdate();
                if (nbRows == 1) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        article.setNoArticle(rs.getInt(1));
                    }
                }	
		} catch(Exception e) {
		    e.printStackTrace();
			throw new ArticleVenduDALException("Article DAL - Impossible d'insérer l'article");
		}

        return article;
	}
	
	@Override
	public ArticleVendu selectById(Integer id) throws ArticleVenduDALException {
		ArticleVendu article = null;
		ResultSet rs = null;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_ID);) {

			stmt.setInt(1, id);
			rs = stmt.executeQuery();	

			if (rs.next()) {
				LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();

				article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"),dateDebut, dateFin, rs.getInt("prix_initial"), 
						rs.getInt("prix_vente"));

			}
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Article DAL - Séléction par identifiant échoué !");
		}
		return article;
  }
  
	@Override
	public ArticleVendu update(ArticleVendu article) throws ArticleVenduDALException {
		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
			stmt.setInt(9, article.getNoArticle());
			stmt.executeUpdate();
			
    	} catch(Exception e) {
    	    e.printStackTrace();
//    		throw new ArticleVenduDALException("Article DAL - La modification de l'article a échoué !");
    	}
        return article;
		
	}

	@Override
	public void delete(Integer id) throws ArticleVenduDALException {
		try (Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(DELETE);) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Suppresion non effectue");
		}
		
	}

	@Override
	public List<ArticleVendu> selectByNom(String motCle) throws ArticleVenduDALException {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		ResultSet rs = null;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_MOT_CLE);
		        ) {

			stmt.setString(1, "%"+ motCle +"%");
			rs = stmt.executeQuery();
			ArticleVendu artVe = null;
			Utilisateur user = null;
			Categorie categ = null;

			while (rs.next()) {
				LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();
                try {
                    user = daoUsers.findById(rs.getInt("no_utilisateur"));
                } catch (UserDALException e) {
                    e.printStackTrace();
                }
                try {
                    categ = daoCategories.findById(rs.getInt("no_categorie"));
                } catch (CategorieDALException e) {
                    e.printStackTrace();
                }
				artVe = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"),dateDebut, dateFin, rs.getInt("prix_initial"), 
						rs.getInt("prix_vente"), user, categ);		
				
				liste.add(artVe);
			}
		
		} catch (SQLException e) {
//		    e.printStackTrace();
			throw new ArticleVenduDALException("Article DAL - La séléction par nom a échoué !");
		}
		return liste;
	}
	
	@Override
	public List<ArticleVendu> selectByNomAndCateg(String motCle, Integer idCat) throws ArticleVenduDALException {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		ResultSet rs = null;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_MOT_CATEG);) {

			stmt.setString(1, "%"+ motCle +"%");
			stmt.setInt(2, idCat);
			rs = stmt.executeQuery();
			ArticleVendu artVe = null;
			Utilisateur user = null;
            Categorie categ = null;
			while (rs.next()) {
				LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();
				try {
                    user = daoUsers.findById(rs.getInt("no_utilisateur"));
                } catch (UserDALException e) {
                    e.printStackTrace();
                }
                try {
                    categ = daoCategories.findById(rs.getInt("no_categorie"));
                } catch (CategorieDALException e) {
                    e.printStackTrace();
                }
				artVe = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
                        rs.getString("description"),dateDebut, dateFin, rs.getInt("prix_initial"), 
                        rs.getInt("prix_vente"), user, categ);
				
				
				liste.add(artVe);
			}
			
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Article DAL - La séléction par nom et catégorie a échoué !");
		}
		return liste;
	}

	@Override
	public List<ArticleVendu> selectByCategorie(Integer idCat) throws ArticleVenduDALException {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		ResultSet rs = null;
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_CATEGORIE);) {

			stmt.setInt(1, idCat);
			rs = stmt.executeQuery();
			ArticleVendu artVe = null;
            Utilisateur user = null;
            Categorie categ = null;

			while (rs.next()) {
				LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();

				try {
                    user = daoUsers.findById(rs.getInt("no_utilisateur"));
                } catch (UserDALException e) {
                    e.printStackTrace();
                }
                try {
                    categ = daoCategories.findById(rs.getInt("no_categorie"));
                } catch (CategorieDALException e) {
                    e.printStackTrace();
                }
                artVe = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
                        rs.getString("description"),dateDebut, dateFin, rs.getInt("prix_initial"), 
                        rs.getInt("prix_vente"), user, categ);
				
				
				liste.add(artVe);
			}
			
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Article DAL - La séléction par catégorie a échoué !");
		}
		return liste;
	}
}
