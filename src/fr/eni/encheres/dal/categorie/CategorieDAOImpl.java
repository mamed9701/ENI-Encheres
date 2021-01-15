/**
 * 
 */
package fr.eni.encheres.dal.categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.user.UserDALException;


/**
 * @author ramon
 *
 */
public class CategorieDAOImpl implements CategorieDAO {
    private static final String SQL_INSERT = "insert into categories(libelle) values(?)";
    private static final String SQL_SELECT_ALL = "select * from categories";
    private static final String SQL_SELECT_BY_LIBELLE = "select * from categories where libelle = ?";
    private static final String SQL_SELECT_BY_ID = "select * from categories where no_categorie = ?";

    
    
    @Override
    public Categorie findByLibelle(String libelle) throws CategorieDALException {
        Categorie categorie = null;
        ResultSet rs = null;
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_BY_LIBELLE);
               ) {
                rqt.setString(1, libelle);
                rs = rqt.executeQuery();
                
                while (rs.next()) {
                    categorie = new Categorie();
                    categorie.setNoCategorie(rs.getInt("no_categorie"));
                    categorie.setLibelle(rs.getString("libelle"));
                    
                }
           } catch (SQLException e) {
               throw new CategorieDALException("Categorie DAL - La récuperation des données a échoué !");
           }
        return categorie;
    }
    
    @Override
    public List<Categorie> showAll() throws CategorieDALException {
        List<Categorie> result = new ArrayList<Categorie>();
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_ALL);
               ) {
               ResultSet rs = rqt.executeQuery();
               while (rs.next()) {
                   Categorie categorie = new Categorie();
                   categorie.setNoCategorie(rs.getInt("no_categorie"));
                   categorie.setLibelle(rs.getString("libelle"));
                   result.add(categorie);
               }

           } catch (SQLException e) {
               throw new CategorieDALException("Categorie DAL - La récuperation des données a échoué !");
           }
        return result;
    }

    @Override
    public Categorie findById(Integer id) throws CategorieDALException {
        Categorie categorie = null;
        ResultSet rs = null;
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
               ) {
                rqt.setInt(1, id);
                rs = rqt.executeQuery();
                
                while (rs.next()) {
                    categorie = new Categorie();
                    categorie.setNoCategorie(rs.getInt("no_categorie"));
                    categorie.setLibelle(rs.getString("libelle"));
                    
                }
           } catch (SQLException e) {
               throw new CategorieDALException("Categorie DAL - La récuperation des données a échoué !");
           }
        return categorie;
    }

    @Override
    public Categorie insert(Categorie categorie) throws CategorieDALException {
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pst = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
               ) {
               pst.setString(1, categorie.getLibelle());

               int nbRows = pst.executeUpdate();
               if (nbRows == 1) {
                   ResultSet rs = pst.getGeneratedKeys();
                   if (rs.next()) {                       
                       categorie.setNoCategorie(rs.getInt(1));              
                   }
               }

           } catch (SQLException e) {
               e.printStackTrace();
               throw new CategorieDALException("Categorie DAL - L'insertion dans la base de données a échoué !");
           }
        return categorie;
    }


}
