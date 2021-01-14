/**
 * 
 */
package fr.eni.encheres.dal.retrait;

import java.util.List;

import fr.eni.encheres.bo.Retrait;

/**
 * @author ramon
 * 
 */
public interface RetraitDAO {
    /**
     * @param retrait
     * @return
     * @throws RetraitDALException
     */
    public void insert(Retrait retrait) throws RetraitDALException;
    /**
     * @param id
     * @throws RetraitDALException
     */
    public void delete(Integer id) throws RetraitDALException;
    /**
     * @return
     * @throws RetraitDALException
     */
    public List<Retrait> showAll() throws RetraitDALException;
}
