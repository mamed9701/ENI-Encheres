package fr.eni.encheres.test;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.user.UserDALException;
import fr.eni.encheres.dal.user.UserDAO;


public class TestUserDAO {
    private static UserDAO daoUsers = DAOFactory.getUserDAO();

    public static void main(String[] args) throws UserDALException {
        Utilisateur user1 = new Utilisateur("rr19", "user", "one", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user2 = new Utilisateur("tt20", "user", "two", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user3 = new Utilisateur("ss21", "user", "three", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        Utilisateur user4 = new Utilisateur("yy22", "user", "four", "test@test.com", "123456789", "1 rue du port", "29000", "Quimper", "123456", 0, false);
        //insert
        daoUsers.insert(user1);
        daoUsers.insert(user2);
        daoUsers.insert(user3);
        daoUsers.insert(user4);
        //find by id
        System.out.println(daoUsers.findById(1));
        //edit
//        System.out.println(user2.toString());
//        user2 = daoUsers.edit(user3);
//        System.out.println(user2.toString());
//        //delete
//        daoUsers.delete(34);
//        //find by username
//        Utilisateur foundByUname = daoUsers.findByUsername(user4.getPseudo());
//        System.out.println(foundByUname.toString());
//        //show all
//        System.out.println(daoUsers.showAll());

    }

}
