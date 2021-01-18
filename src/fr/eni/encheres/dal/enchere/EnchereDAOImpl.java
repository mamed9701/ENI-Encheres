/**
 * 
 */
package fr.eni.encheres.dal.enchere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.article.ArticleVenduDALException;
import fr.eni.encheres.dal.article.ArticleVenduDAO;
import fr.eni.encheres.dal.user.UserDALException;
import fr.eni.encheres.dal.user.UserDAO;

/**
 * @author ramon
 *
 */
public class EnchereDAOImpl implements EnchereDAO {
    private UserDAO userDAO = DAOFactory.getUserDAO();
    private ArticleVenduDAO articleDAO = DAOFactory.getArticleDAO();
    
    private static final String SQL_INSERT = "insert into encheres(date_enchere, montant_enchere, no_article, no_utilisateur) values(?,?,?,?)";
    private static final String SQL_SELECT_ALL_BY_USER = "select * from encheres where no_utilisateur = ?";
    private static final String SQL_SELECT_BY_ID = "select * from encheres where no_enchere = ?";
    private static final String SQL_SELECT_ALL = "select * from encheres";
    private static final String SQL_UPDATE = "update encheres set date_enchere=?, montant_enchere=?"
            +" where no_utilisateur=?";

    @Override
    public Enchere insert(Enchere enchere) throws EnchereDALException {
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pst = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
               ) {
               pst.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
               pst.setInt(2, enchere.getMontantEnchere());
               pst.setInt(3, enchere.getArticle().getNoArticle());
               pst.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
               
               int nbRows = pst.executeUpdate();
               if (nbRows == 1) {
                   ResultSet rs = pst.getGeneratedKeys();
                   if (rs.next()) {
                       enchere.setNoEnchere(rs.getInt(1));
                   }
               }

           } catch (SQLException e) {
               e.printStackTrace();
               throw new EnchereDALException("Enchere DAL - L'insertion dans la base de données a échoué !");
           }
        return enchere;
    }

    @Override
    public List<Enchere> getAllByUser(Integer id) throws EnchereDALException {
        Utilisateur user = null;
        try {
            user = userDAO.findById(id);
        } catch (UserDALException e1) {
            e1.printStackTrace();
        }
        
        List<Enchere> result = new ArrayList<Enchere>();
        ResultSet rs = null;
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_ALL_BY_USER);
               ) {
                rqt.setInt(1, id);
                rs = rqt.executeQuery();
                
                while (rs.next()) {
                    ArticleVendu article = null;
                    try {
                        article = articleDAO.selectById(rs.getInt("no_article"));
                    } catch (ArticleVenduDALException e) {
                        e.printStackTrace();
                    }
                    LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
                    Enchere enchere = new Enchere();
                    enchere.setNoEnchere(rs.getInt("no_enchere"));
                    enchere.setDateEnchere(dateEnchere);
                    enchere.setMontantEnchere(rs.getInt("montant_enchere"));
                    enchere.setArticle(article);
                    enchere.setUtilisateur(user);
                    
                    result.add(enchere);
                }
           } catch (SQLException e) {
               e.printStackTrace();
//               throw new EnchereDALException("La récuperation des données a échoué !");
           }
        return result;
    }

    @Override
    public List<Enchere> showAll() throws EnchereDALException {
        Utilisateur user = new Utilisateur();

        List<Enchere> result = new ArrayList<Enchere>();
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_ALL);
               ) {
               ResultSet rs = rqt.executeQuery();
               while (rs.next()) {
                   ArticleVendu article = null;
                   try {
                       article = articleDAO.selectById(rs.getInt("no_article"));
                   } catch (ArticleVenduDALException e) {
                       e.printStackTrace();
                   }
                   LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
                   Enchere enchere = new Enchere();
                   enchere.setNoEnchere(rs.getInt("no_enchere"));
                   enchere.setDateEnchere(dateEnchere);
                   enchere.setMontantEnchere(rs.getInt("montant_enchere"));
                   enchere.setArticle(article);
                   enchere.setUtilisateur(user);
                   
                   result.add(enchere);
               }

           } catch (SQLException e) {
               throw new EnchereDALException("Retrait DAL - La récuperation des données a échoué !");
           }
        return result;
    }

	@Override
	public Enchere update(Enchere enchere) throws EnchereDALException {
		try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pst = cnx.prepareStatement(SQL_UPDATE);
               ) {
               pst.setDate(1, Date.valueOf(enchere.getDateEnchere()));
               pst.setInt(2, enchere.getMontantEnchere());
               pst.setInt(3, enchere.getUtilisateur().getNoUtilisateur());
               
               
               pst.executeUpdate();           

           } catch (SQLException e) {
               e.printStackTrace();
               throw new EnchereDALException("Enchere DAL - La modification d'une enchère dans la base de données a échoué !");
           }
        return enchere;
	}

    
	@Override
    public Enchere findById(Integer id) throws EnchereDALException {
	    Enchere enchere = null;
        ResultSet rs = null;
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
               ) {
                rqt.setInt(1, id);
                rs = rqt.executeQuery();
                
                Utilisateur user = null;
                ArticleVendu article = null;
                
                if (rs.next()) {
                    try {
                        user = userDAO.findById(rs.getInt("no_utilisateur"));
                    } catch (UserDALException e) {
                        e.printStackTrace();
                    }
                    try {
                        article = articleDAO.selectById(rs.getInt("no_article"));
                    } catch (ArticleVenduDALException e) {
                        e.printStackTrace();
                    }
                    LocalDate dateEnchere = rs.getDate("date_enchere").toLocalDate();
                    enchere = new Enchere(
                            rs.getInt("no_enchere"),
                            dateEnchere,
                            rs.getInt("montant_enchere"),
                            user,
                            article
                            );
                }
           } catch (SQLException e) {
               throw new EnchereDALException("Enchere DAL - La récuperation d'une enchere par identifiant a échoué !");
           }
        return enchere;
    }

}
