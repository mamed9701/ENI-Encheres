package fr.eni.encheres.dal.article;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;

/**
 * @author Melvyn
 *
 */
public interface ArticleVenduDAO {
	public List<ArticleVendu> selectById(Integer id) throws ArticleVenduDALException;
	public ArticleVendu insert(ArticleVendu article) throws ArticleVenduDALException;
	public ArticleVendu update(ArticleVendu article) throws ArticleVenduDALException;
	public void delete(Integer id) throws ArticleVenduDALException;
	public List<ArticleVendu> selectByNom(String motCle) throws ArticleVenduDALException;
	public List<ArticleVendu> selectByNomAndCateg(String motCle, Integer idCat) throws ArticleVenduDALException;
	public List<ArticleVendu> selectByCategorie(Integer idCat) throws ArticleVenduDALException;
	
}
