package fr.eni.encheres.dal.article;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ConnectionProvider;


public class ArticleVendusDAOImpl implements ArticleVenduDAO {  
	private String INSERT = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie)"
	        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private String UPDATE = "UPDATE articles_vendus"
	        +" set nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=?"
	        +" where no_article=?";
	private String DELETE = "DELETE FROM Articles_Vendus WHERE no_article = ?;";
	private String SELECT_ID = "SELECT * FROM Articles_Vendus WHERE no_article = ?;";
	private String SELECT_MOT_CLE = "SELECT * FROM Articles_Vendus WHERE nom_article LIKE '%?%';";
	private String SELECT_MOT_CATEG = "SELECT * FROM Articles_Vendus WHERE nom_article LIKE '%?%' AND no_categorie = ?;";
	private String SELECT_CATEGORIE = "SELECT * FROM Articles_Vendus WHERE no_categorie = ?;";

	
	

	@Override
	public ArticleVendu insert(ArticleVendu article) throws ArticleVenduDALException {
	    Utilisateur user = article.getUtilisateur();
        Categorie categorie = article.getCategorie();
        
		try( Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
		        ) {
				stmt.setString(1, article.getNomArticle());
				stmt.setString(2, article.getDescription());
				stmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
				stmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
		
				if (null != article.getMiseAPrix()) {
				    stmt.setInt(5, article.getMiseAPrix());                
				}else {
				    stmt.setNull(5, Types.NULL);   
				}
				if (null != article.getPrixVente()) {
                    stmt.setInt(6, article.getPrixVente());                    
                }else {
                    stmt.setNull(6, Types.NULL);   
                }
        
  			stmt.setInt(7, user.getNoUtilisateur());
				stmt.setInt(8, categorie.getNoCategorie());
				
                int nbRows = stmt.executeUpdate();
                if (nbRows == 1) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        article.setNoArticle(rs.getInt(1));
                    }
                }	
		} catch(Exception e) {
//		    e.printStackTrace();
			throw new ArticleVenduDALException("Impossible d'insérer l'article");
		}
        return article;
	}
	


	@Override
	public void update(ArticleVendu article) throws ArticleVenduDALException {
		try( Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = cnx.prepareStatement(UPDATE);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, Date.valueOf(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, article.getCategorie().getNoCategorie());
			stmt.executeUpdate();
			
	} catch(Exception e) {
		throw new ArticleVenduDALException("Impossible d'insérer l'article");
	}
		
	}

	@Override
	public void delete(Integer id) throws ArticleVenduDALException {
		try (Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stmt = cnx.prepareStatement(DELETE);) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Suppresion non effectue");
		}
		
	}
	
	@Override
	public List<ArticleVendu> selectById(Integer id) throws ArticleVenduDALException {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_ID);) {

			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				ArticleVendu artVe = null;

				while (rs.next()) {
					LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
					LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();

						artVe = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
								rs.getString("description"),dateDebut, dateFin, rs.getInt("prix_initial"), 
								rs.getInt("prix_vente"));
					
					
					liste.add(artVe);
				}
			}
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Impossible d'effetue l'opération");
		}
		return liste;
	}

	@Override
	public List<ArticleVendu> selectByNom(String motCle) throws ArticleVenduDALException {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_MOT_CLE);) {

			stmt.setString(1, motCle);
			try (ResultSet rs = stmt.executeQuery();) {
				ArticleVendu artVe = null;

				while (rs.next()) {
					LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
					LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();

						artVe = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
								rs.getString("description"),dateDebut, dateFin, rs.getInt("prix_initial"), 
								rs.getInt("prix_vente"));
					
					
					liste.add(artVe);
				}
			}
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Impossible d'effetue l'opération");
		}
		return liste;
	}
	@Override
	public List<ArticleVendu> selectByNomAndCateg(String motCle, Integer idCat) throws ArticleVenduDALException {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_MOT_CATEG);) {

			stmt.setString(1, motCle);
			stmt.setInt(2, idCat);
			try (ResultSet rs = stmt.executeQuery();) {
				ArticleVendu artVe = null;

				while (rs.next()) {
					LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
					LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();

						artVe = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
								rs.getString("description"),dateDebut, dateFin, rs.getInt("prix_initial"), 
								rs.getInt("prix_vente"));
					
					
					liste.add(artVe);
				}
			}
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Impossible d'effetue l'opération");
		}
		return liste;
	}



	@Override
	public List<ArticleVendu> selectByCategorie(Integer idCat) throws ArticleVenduDALException {
		List<ArticleVendu> liste = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement stmt = cnx.prepareStatement(SELECT_CATEGORIE);) {

			stmt.setInt(1, idCat);
			try (ResultSet rs = stmt.executeQuery();) {
				ArticleVendu artVe = null;

				while (rs.next()) {
					LocalDate dateDebut = rs.getDate("date_debut_encheres").toLocalDate();
					LocalDate dateFin = rs.getDate("date_fin_encheres").toLocalDate();

						artVe = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
								rs.getString("description"),dateDebut, dateFin, rs.getInt("prix_initial"), 
								rs.getInt("prix_vente"));
					
					
					liste.add(artVe);
				}
			}
		} catch (SQLException e) {
			throw new ArticleVenduDALException("Impossible d'effetue l'opération");
		}
		return liste;
	}





}
