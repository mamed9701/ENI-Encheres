package fr.eni.encheres.ihm.accueil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    List<Enchere> listeEncheresByUser = new ArrayList<>();   
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
		Utilisateur currentUser = null;
		

		//TODO filtres: categ libelle -> findByLibelle(param formulaire)
		//if "".equals("get param filtre")
		
		
		
		if (null != request.getSession().getAttribute("login")) {
			Integer id = (Integer) request.getSession().getAttribute("login");
			try {
				currentUser = userManager.afficherUtilisateur(id);
			} catch (BLLException e) {
				e.printStackTrace();
			}			
		}
		
        try {
            listeCategories = manager.getAllCategories();           
            model.setListCategories(listeCategories);
        } catch (BLLException e) {
            e.printStackTrace();
        }

        if (null != currentUser) {
        	try {
        		listeEncheresByUser = manager.getEncheresByUser(currentUser.getNoUtilisateur());
        		System.out.println(listeEncheresByUser);
				model.setListEncheres(listeEncheresByUser);
				request.setAttribute("model", model);
				request.getRequestDispatcher("afficherEncheres.jsp").forward(request, response);			
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("nelogat");
			try {
				listeEncheres = manager.getAllEncheres();
	            model.setListEncheres(listeEncheres);         
	        } catch (BLLException e) {
	            request.setAttribute("message", e.getMessage());
	        }
			model.setListEncheres(listeEncheres);
			request.setAttribute("model", model);
			request.getRequestDispatcher("accueil.jsp").forward(request, response);			
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
