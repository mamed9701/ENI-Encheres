/**
 * 
 */
package fr.eni.encheres.dal.retrait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.ConnectionProvider;

/**
 * @author ramon
 *
 */
public class RetraitDAOImpl implements RetraitDAO {
    private static final String SQL_INSERT = "insert into retraits(no_article, rue, code_postal, ville) values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from retraits where no_article=?";
    private static final String SQL_SELECT_ALL = "select * from retraits";
    
    @Override
    public void insert(Retrait retrait) throws RetraitDALException {
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pst = cnx.prepareStatement(SQL_INSERT);
               ){
            pst.setInt(1, retrait.getArticle().getNoArticle());
            pst.setString(2, retrait.getRue());
            pst.setString(3, retrait.getCodePostal());
            pst.setString(4, retrait.getVille());
            
            pst.executeUpdate();

        } catch (Exception e) {
//            e.printStackTrace();
            throw new RetraitDALException("Retrait DAL - problème dans l'insertion d'un retrait");
        }
    }

    @Override
    public void delete(Integer id) throws RetraitDALException {
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pst = cnx.prepareStatement(SQL_DELETE);
               ) {
                pst.setInt(1, id);
                pst.executeUpdate();         

           } catch (SQLException e) {
               e.printStackTrace();
               throw new RetraitDALException("Retrait DAL - La suppression d'un point de retrait a échoué !");
           }        
    }

    @Override
    public List<Retrait> showAll() throws RetraitDALException {
        //TODO : remplacer article ici avec la méthode findById() de ArticleVendu avec rs.getInt("no_article") en paramètre
        ArticleVendu article = new ArticleVendu();
        List<Retrait> result = new ArrayList<Retrait>();
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_ALL);
               ) {
               ResultSet rs = rqt.executeQuery();
               while (rs.next()) {
                   Retrait retrait = new Retrait();
                   retrait.setArticle(article);
                   retrait.setRue(rs.getString("rue"));
                   retrait.setCodePostal(rs.getString("code_postal"));
                   retrait.setVille(rs.getString("ville"));
                   result.add(retrait);
               }

           } catch (SQLException e) {
               throw new RetraitDALException("Retrait DAL - La récuperation des données a échoué !");
           }
        return result;
    }

}
