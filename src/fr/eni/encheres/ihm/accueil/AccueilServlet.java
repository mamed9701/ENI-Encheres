package fr.eni.encheres.ihm.accueil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.model.core.ID;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.enchere.EnchereManager;
import fr.eni.encheres.bll.enchere.EnchereManagerSingl;
import fr.eni.encheres.bll.user.UserManager;
import fr.eni.encheres.bll.user.UserManagerSingl;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSingl.getInstance();
	private UserManager userManager = UserManagerSingl.getInstance();
    List<Enchere> listeEncheres = new ArrayList<>();   
    List<Categorie> listeCategories = new ArrayList<>(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccueilModel model = new AccueilModel();
		
		if("".equals(request.getParameter("filtre"))) {
			try {
				manager.trouverParLibelle(request.getParameter("filtre"));
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(null != request.getParameter("categories") && "".equals(request.getParameter("filtre"))) {
			//manager.parCatEtLibelle()
		}
		
		
		
		
		try {
            model.setListEncheres(manager.getAllEncheres());
        } catch (BLLException e) {
            request.setAttribute("message", e.getMessage());
        }
      
        try {
            listeCategories = manager.getAllCategories();
            model.setListCategories(listeCategories);
            System.out.println(listeCategories);
        } catch (BLLException e) {
            e.printStackTrace();
        }
        
        Utilisateur currentUser = null;
        if (null != request.getSession().getAttribute("login")) {
			// retrieve the current user id from session and search it in the database
			Integer id = (Integer) request.getSession().getAttribute("login");
			try {
				currentUser = userManager.afficherUtilisateur(id);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
    	request.setAttribute("model", model);
		request.getRequestDispatcher("afficherEncheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
