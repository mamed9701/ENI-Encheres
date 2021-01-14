/**
 * 
 */
package fr.eni.encheres.dal.categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.retrait.RetraitDALException;

/**
 * @author ramon
 *
 */
public class CategorieDAOImpl implements CategorieDAO {
    private static final String SQL_SELECT_ALL = "select * from categories";
    
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

}
