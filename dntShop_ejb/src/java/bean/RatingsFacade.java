/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Ratings;
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
public class RatingsFacade extends AbstractFacade<Ratings> implements RatingsFacadeLocal {
    @PersistenceContext(unitName = "dntShop_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RatingsFacade() {
        super(Ratings.class);
    }

    @Override
    public List<Ratings> AllRatingByProductID(String proid) {
        Query q = getEntityManager().createQuery("SELECT r FROM Ratings r WHERE r.productID.productID = :proid");
        q.setParameter("proid", proid);
        return q.getResultList();
    }
}
