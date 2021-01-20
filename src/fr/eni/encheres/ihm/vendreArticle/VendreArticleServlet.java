package fr.eni.encheres.ihm.vendreArticle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.enchere.EnchereManager;
import fr.eni.encheres.bll.enchere.EnchereManagerSingl;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Retrait;

/**
 * Servlet implementation class VendreArticleServlet
 */
@WebServlet("/vendre-article")
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSingl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendreArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VendreArticleModel model = new VendreArticleModel();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		if(null != request.getParameter("nom")) {
			Categorie categorie = null;
			
			Date date_debut = null;
			Date date_fin = null;
			
			try {
				categorie = manager.trouverParLibelle(request.getParameter("categorie"));
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			ArticleVendu article = new ArticleVendu();
			article.setNomArticle(request.getParameter("nom"));
			article.setDescription(request.getParameter("description"));
			article.setCategorie(categorie);
			article.setMiseAPrix(Integer.parseInt(request.getParameter("miseAPrix")));
			article.setPrixVente(0);
			try {
				date_debut = sdf.parse(request.getParameter("debut_e"));
				date_fin = sdf.parse(request.getParameter("fin_e"));
			} catch (ParseException e) {
				request.setAttribute("message", "Problème dans le format de la date !!");
			}
			article.setDateDebutEncheres(date_debut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			article.setDateFinEncheres(date_fin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			
			ArticleVendu newArticle = null;
			try {
				newArticle = manager.ajouterArticle(article);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			Retrait retrait = new Retrait();
			retrait.setRue(request.getParameter("rue_profil"));
			retrait.setCodePostal(request.getParameter("cdp_profil"));
			retrait.setVille(request.getParameter("ville_profil"));
			retrait.setArticle(newArticle);
			
			try {
				manager.ajoutRetrait(retrait);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("ajouterArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
