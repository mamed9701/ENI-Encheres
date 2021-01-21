package fr.eni.encheres.ihm.encherir;

import java.io.IOException;
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
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/encherir")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager userManager = UserManagerSingl.getInstance();
	private EnchereManager enchereManager = EnchereManagerSingl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncherirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncherirModel model = new EncherirModel();
		String idParam = request.getParameter("id");
		ArticleVendu article = null;
		try {
			article = enchereManager.getArticleParId(Integer.parseInt(idParam));
		} catch (NumberFormatException | BLLException e1) {
			e1.printStackTrace();
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
		System.out.println(article);
		model.setArticle(article);
		model.setUser(currentUser);
		request.setAttribute("model", model);
	
		request.getRequestDispatcher("encherir.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
