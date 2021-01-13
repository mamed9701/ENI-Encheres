/**
 * 
 */
package fr.eni.encheres.dal.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;
import fr.eni.encheres.dal.DAOFactory;


/**
 * @author ramon
 *
 */
public class UserDAOImpl implements UserDAO {
    private UserDAO daoUsers = DAOFactory.getUserDAO();

    private static final String SQL_INSERT = "insert into utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)"
            + " values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID = "select no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur"
            +" from utilisateurs where no_utilisateur = ?";
    private static final String SQL_UPDATE = "update utilisateurs set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?"
            +" where no_utilisateur=?";
    private static final String SQL_DELETE = "delete from utilisateurs where no_utilisateur=?";
    private static final String SQL_SELECT_BY_NAME = "select no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur"
            +" from utilisateurs where nom = ?";
    private static final String SQL_SELECT_ALL = "select * from utilisateurs";

    @Override
    public Utilisateur insert(Utilisateur user) throws UserDALException {
        // TODO Insert into DB a new user
        
        return null;
    }

    @Override
    public Utilisateur show(Integer id) throws UserDALException {
        // TODO Select user by id
        return null;
    }

    @Override
    public Utilisateur edit(Integer id) throws UserDALException {
        // TODO Update user
        return null;
    }

    @Override
    public void delete(Integer id) throws UserDALException {
        // TODO Delete user
        
    }

    @Override
    public Utilisateur findByUsername(String username) throws UserDALException {
        // TODO Select user where name = username
        return null;
    }

    @Override
    public List<Utilisateur> showAll() throws UserDALException {
        // TODO Select all from users
        return null;
    }

}
