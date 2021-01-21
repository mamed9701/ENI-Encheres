package fr.eni.encheres.ihm.modifierUtilisateur;

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
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/edit")
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserManager manager = UserManagerSingl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfilServlet() {
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
				
				model.setUtilisateur(currentUser);
				request.setAttribute("model", model);
				request.getRequestDispatcher("modifierProfil").forward(request, response);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			//check if the modification form has been submitted
			if (null != request.getParameter("pseudo")) {
				String pseudo = request.getParameter("pseudo");
			    String nom = request.getParameter("nom");
			    String prenom = request.getParameter("prenom");
			    String email = request.getParameter("email");
			    String telephone = request.getParameter("telephone");
			    String rue = request.getParameter("rue");
			    String ville = request.getParameter("ville");
			    String code = request.getParameter("code-postal");
			    String pwd = request.getParameter("current-password");
			    String npwd = request.getParameter("new-password");
			    String confirm = request.getParameter("confirm-password");
			    
//			    System.out.println(currentUser);
//			    System.out.println(pwd);
//			    System.out.println(npwd);
//			    System.out.println(confirm);
			    
			    if (pwd.equals(currentUser.getMotDePasse()) && npwd.equals(confirm)) {
			    	System.out.println(pwd);
			    	System.out.println(currentUser.getMotDePasse());
			    	System.out.println(npwd);
			    	System.out.println(confirm);
			    	currentUser.setPseudo(pseudo);
			    	currentUser.setNom(nom);
			    	currentUser.setPrenom(prenom);
			    	currentUser.setEmail(email);
			    	currentUser.setTelephone(telephone);
			    	currentUser.setRue(rue);
			    	currentUser.setVille(ville);
			    	currentUser.setCodePostal(code);
			    	currentUser.setMotDePasse(npwd);
			    	
			    	try {
						manager.modifierUtilisateur(currentUser);
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}else {					
	            	request.setAttribute("error", "Les mots de passe ne correspondent pas !");	            	
	                         
	            }
			    
			}
			
		}else {
			response.sendRedirect("/ENI-Encheres/login");
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
