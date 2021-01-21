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
import fr.eni.encheres.ihm.modifierUtilisateur.ModifierProfilModel;

/**
 * Servlet implementation class SuppressionCompteServlet
 */
@WebServlet("/supprimer")
public class SuppressionCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserManager manager = UserManagerSingl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuppressionCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModifierProfilModel model = new ModifierProfilModel();
		Utilisateur currentUser = null;
		if (null != request.getSession().getAttribute("login") ) {
			//retrieve the current user id from session and search it in the database
			Integer id = (Integer) request.getSession().getAttribute("login");
			try {
				currentUser = manager.afficherUtilisateur(id);
	
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		if (null != currentUser) {
			model.setUtilisateur(currentUser);
			request.setAttribute("model", model);
			
			try {
				manager.supprimerUtilisateur(currentUser.getNoUtilisateur());
				response.sendRedirect("/ENI-Encheres/accueil");
			} catch (BLLException e) {
				request.setAttribute("error", "La suppression de votre compte n'est pas possible");
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("modifierProfil.jsp").forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
