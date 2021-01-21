package fr.eni.encheres.ihm.afficherUtilisateur;

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
 * Servlet implementation class AfficherUtilisateurServlet
 */
@WebServlet("/afficher-utilisateur")
public class AfficherUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager userManager = UserManagerSingl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AfficherUtilisateurModel model = new AfficherUtilisateurModel();
		
		Utilisateur currentUser = null;
		if (null != request.getSession().getAttribute("login") ) {
			//retrieve the current user id from session and search it in the database
			Integer id = (Integer) request.getSession().getAttribute("login");
			try {
				currentUser = userManager.afficherUtilisateur(id);
				model.setUtilisateur(currentUser);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			model.setUtilisateur(currentUser);
			request.setAttribute("model", model);
			
			request.getRequestDispatcher("monProfil.jsp").forward(request, response);
		}else{
			request.setAttribute("model", model);
			request.getRequestDispatcher("profil.jsp").forward(request, response);
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
