/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Brands;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Duy
 */
@Stateless
public class BrandsFacade extends AbstractFacade<Brands> implements BrandsFacadeLocal {
    @PersistenceContext(unitName = "dntShop_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BrandsFacade() {
        super(Brands.class);
    }
    
    @Override
    public List<Brands> AllBrands() {
        Query q = getEntityManager().createQuery("SELECT b FROM Brands b WHERE b.isStatus = :status");
        boolean status=true;
        q.setParameter("status", status);
        return q.getResultList();
    }
    
}
