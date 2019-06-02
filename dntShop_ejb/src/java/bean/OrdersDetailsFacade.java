/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.OrdersDetails;
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
public class OrdersDetailsFacade extends AbstractFacade<OrdersDetails> implements OrdersDetailsFacadeLocal {
    @PersistenceContext(unitName = "dntShop_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersDetailsFacade() {
        super(OrdersDetails.class);
    }
    
@Override
    public List<OrdersDetails> findByOrderId(String id) {
        Query q=em.createQuery("SELECT o FROM OrdersDetails o WHERE o.orderID.orderID = :orderid");
        q.setParameter("orderid", id);
        return q.getResultList();
    }
    
}
