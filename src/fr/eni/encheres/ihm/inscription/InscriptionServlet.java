package fr.eni.encheres.ihm.inscription;

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
 * Servlet implementation class CreCompte
 */
@WebServlet("/register")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager manager = UserManagerSingl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InscriptionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InscriptionModel model = new InscriptionModel();

		if (null != request.getParameter("pseudo")) {
		    String pseudo = request.getParameter("pseudo");
		    String nom = request.getParameter("nom");
		    String prenom = request.getParameter("prenom");
		    String email = request.getParameter("email");
		    String telephone = request.getParameter("telephone");
		    String rue = request.getParameter("rue");
		    String ville = request.getParameter("ville");
		    String code = request.getParameter("code-postal");
		    String pwd = request.getParameter("password");
		    String confirm = request.getParameter("confirm-password");
		    
		    Integer credit = 0;
		    Boolean administrateur = false;
		    
		    Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code, ville, pwd, credit, administrateur);
		    model.setUtilisateur(user);

		    if (pwd.equals(confirm)) {
                user.setMotDePasse(pwd);
                try {
                    user = manager.inscription(user);  
                    //login the user
                    request.getSession().setAttribute("login", user.getNoUtilisateur());   
                    model.setUtilisateur(user);
                    
                    response.sendRedirect("/ENI-Encheres/afficherEncheres");
                    
                } catch (BLLException e) {
                    e.printStackTrace();
                }
                
            }else {
            	request.setAttribute("error", "Les mots de passe ne correspondent pas !");
                request.setAttribute("model", model);
                request.getRequestDispatcher("inscription.jsp").forward(request, response);                   
            }
    
		}else {
		    request.setAttribute("model", model);
	        request.getRequestDispatcher("inscription.jsp").forward(request, response);
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
