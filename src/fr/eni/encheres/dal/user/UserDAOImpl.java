/**
 * 
 */
package fr.eni.encheres.dal.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;

/**
 * @author ramon
 *
 */
public class UserDAOImpl implements UserDAO {
    private static final String SQL_INSERT = "insert into utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)"
            + " values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "select no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur"
            +" from utilisateurs where no_utilisateur = ?";
    private static final String SQL_UPDATE = "update utilisateurs set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=?"
            +" where no_utilisateur=?";
    private static final String SQL_DELETE = "delete from utilisateurs where no_utilisateur=?";
    private static final String SQL_SELECT_BY_PSEUDO = "select no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur"
            +" from utilisateurs where pseudo = ?";
    private static final String SQL_SELECT_ALL = "select * from utilisateurs";

    @Override
    public Utilisateur insert(Utilisateur user) throws UserDALException {
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pst = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
               ) {
               pst.setString(1, user.getPseudo());
               pst.setString(2, user.getNom());
               pst.setString(3, user.getPrenom());
               pst.setString(4, user.getEmail());
               pst.setString(5, user.getTelephone());
               pst.setString(6, user.getRue());
               pst.setString(7, user.getCodePostal());
               pst.setString(8, user.getVille());
               pst.setString(9, user.getMotDePasse());
               pst.setInt(10, user.getCredit());
               pst.setBoolean(11, user.getAdministrateur());
               
               int nbRows = pst.executeUpdate();
               if (nbRows == 1) {
                   ResultSet rs = pst.getGeneratedKeys();
                   if (rs.next()) {
                       
                       user.setNoUtilisateur(rs.getInt(1));
                   }
               }

           } catch (SQLException e) {
               e.printStackTrace();
               throw new UserDALException("User DAL - L'insertion dans la base de données a échoué !");
           }
        return user;
    }

    @Override
    public Utilisateur findById(Integer id) throws UserDALException {
        Utilisateur user = null;
        ResultSet rs = null;
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_BY_ID);
               ) {
                rqt.setInt(1, id);
                rs = rqt.executeQuery();
                
                if (rs.next()) {
                    user = new Utilisateur(
                            rs.getInt("no_utilisateur"),
                            rs.getString("pseudo"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("rue"),
                            rs.getString("code_postal"),
                            rs.getString("ville"),
                            rs.getString("mot_de_passe"),
                            rs.getInt("credit"),
                            rs.getBoolean("administrateur")
                            );
                }
           } catch (SQLException e) {
               throw new UserDALException("User DAL - La récuperation d'un utilisateur par identifiant a échoué !");
           }
        return user;
    }

    @Override
    public Utilisateur edit(Utilisateur user) throws UserDALException {

        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pst = cnx.prepareStatement(SQL_UPDATE);
               ) {
               pst.setString(1, user.getPseudo());
               pst.setString(2, user.getNom());
               pst.setString(3, user.getPrenom());
               pst.setString(4, user.getEmail());
               pst.setString(5, user.getTelephone());
               pst.setString(6, user.getRue());
               pst.setString(7, user.getCodePostal());
               pst.setString(8, user.getVille());
               pst.setString(9, user.getMotDePasse());
               pst.setInt(10, user.getCredit());
               pst.setBoolean(11, user.getAdministrateur());
               pst.setInt(12, user.getNoUtilisateur());
               
               pst.executeUpdate();           

           } catch (SQLException e) {
               e.printStackTrace();
               throw new UserDALException("User DAL - La modification d'un utilisateur dans la base de données a échoué !");
           }
        return user;
    }

    @Override
    public void delete(Integer id) throws UserDALException {
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pst = cnx.prepareStatement(SQL_DELETE);
               ) {
                pst.setInt(1, id);
                pst.executeUpdate();         

           } catch (SQLException e) {
               e.printStackTrace();
               throw new UserDALException("User DAL - La suppression d'un utilisateur a échoué !");
           }
        
        
    }

    @Override
    public Utilisateur findByUsername(String username) throws UserDALException {
        Utilisateur user = null;
        ResultSet rs = null;
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_BY_PSEUDO);
               ) {
                rqt.setString(1, username);
                rs = rqt.executeQuery();
                
                if (rs.next()) {
                    user = new Utilisateur(
                            rs.getInt("no_utilisateur"),
                            rs.getString("pseudo"),
                            rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("rue"),
                            rs.getString("code_postal"),
                            rs.getString("ville"),
                            rs.getString("mot_de_passe"),
                            rs.getInt("credit"),
                            rs.getBoolean("administrateur")
                            );
                }
           } catch (SQLException e) {
               throw new UserDALException("User DAL - La récuperation d'un utilisateur par nom a échoué !");
           }
        return user;
    }

    @Override
    public List<Utilisateur> showAll() throws UserDALException {
        List<Utilisateur> result = new ArrayList<Utilisateur>();
        try( Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_ALL);
               ) {
               ResultSet rs = rqt.executeQuery();
               while (rs.next()) {
                   Utilisateur user = new Utilisateur();
                   user.setNoUtilisateur(rs.getInt("no_utilisateur"));
                   user.setPseudo(rs.getString("pseudo"));
                   user.setNom(rs.getString("nom"));
                   user.setPrenom(rs.getString("prenom"));
                   user.setEmail(rs.getString("email"));
                   user.setTelephone(rs.getString("telephone"));
                   user.setRue(rs.getString("rue"));
                   user.setCodePostal(rs.getString("code_postal"));
                   user.setVille(rs.getString("ville"));
                   user.setMotDePasse(rs.getString("mot_de_passe"));
                   user.setCredit(rs.getInt("credit"));
                   user.setAdministrateur(rs.getBoolean("administrateur"));
                   
                   result.add(user);
               }

           } catch (SQLException e) {
               throw new UserDALException("User DAL - La récuperation des données a échoué !");
           }
        return result;
    }

}
