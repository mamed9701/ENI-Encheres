package fr.eni.encheres.dal.article;

import java.time.LocalDate;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

/**
 * @author Melvyn
 *
 */
public interface ArticleVenduDAO {
	public ArticleVendu selectById(Integer id) throws ArticleVenduDALException;
	public ArticleVendu insert(ArticleVendu article) throws ArticleVenduDALException;
	public ArticleVendu update(ArticleVendu article) throws ArticleVenduDALException;
	public void delete(Integer id) throws ArticleVenduDALException;
	public List<ArticleVendu> selectByNom(String motCle) throws ArticleVenduDALException;
	public List<ArticleVendu> selectByUtilisateur(Integer id) throws ArticleVenduDALException;
	public List<ArticleVendu> selectByNomAndCateg(String motCle, Integer idCat) throws ArticleVenduDALException;
	public List<ArticleVendu> selectByCategorie(Integer idCat) throws ArticleVenduDALException;
	public List<ArticleVendu> selectByDateDebut(LocalDate debut) throws ArticleVenduDALException;
	public List<ArticleVendu> selectAll() throws ArticleVenduDALException;
	
}
