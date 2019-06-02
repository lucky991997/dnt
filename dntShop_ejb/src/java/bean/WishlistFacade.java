/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Wishlist;
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
public class WishlistFacade extends AbstractFacade<Wishlist> implements WishlistFacadeLocal {
    @PersistenceContext(unitName = "dntShop_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WishlistFacade() {
        super(Wishlist.class);
    }

    @Override
    public List<Wishlist> findbyCustomer(String cusId) {
        Query q=em.createQuery("SELECT w FROM Wishlist w WHERE w.customerID.customerID = :cusId");
        q.setParameter("cusId", cusId);
        return q.getResultList();
    }

    @Override
    public List<Wishlist> findbyProduct(String productId,String cusId) {
        Query q=em.createQuery("SELECT w FROM Wishlist w WHERE w.productID.productID = :productId and w.customerID.customerID = :cusId");
        q.setParameter("productId", productId);
        q.setParameter("cusId", cusId);
        return q.getResultList();
        
    }
    
    
    
}
