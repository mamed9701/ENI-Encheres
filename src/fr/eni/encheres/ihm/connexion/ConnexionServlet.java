package fr.eni.encheres.ihm.connexion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.user.UserManager;
import fr.eni.encheres.bll.user.UserManagerSingl;
import fr.eni.encheres.bo.Utilisateur;


/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager manager = UserManagerSingl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionModel model = new ConnexionModel();
		Utilisateur user = null;
		//get data from login form
		String uname = request.getParameter("user");
		String pwd = request.getParameter("pwd");
                   
        if (null != request.getParameter("user") && null != request.getParameter("pwd")) {
            
            // search in DB if user exists
            try {
                user = manager.connexion(uname, pwd);                          

                if (user != null) {
                    //login the user
                    request.getSession().setAttribute("login", user.getNoUtilisateur());
                    request.getRequestDispatcher("/AccueilServlet").forward(request, response);
                    
                } else {
                    //if the user doesn't exist redirect to register
                    request.setAttribute("status", "Identifiant ou mot de passe incorrect !");
                    request.getRequestDispatcher("connexion.jsp").forward(request, response);
                }
            } catch (BLLException e) {
                e.printStackTrace();
            }


        } else {
            request.setAttribute("model", model);
            request.getRequestDispatcher("connexion.jsp").forward(request, response);
        }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
