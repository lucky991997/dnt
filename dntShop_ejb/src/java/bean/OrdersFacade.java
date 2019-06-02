/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.OrderListThisMonth;
import entity.Orders;
import java.util.Date;
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
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {
    @PersistenceContext(unitName = "dntShop_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }

    @Override
    public List<OrderListThisMonth> OrderListThisMonth() {
        Query q = getEntityManager().createQuery("SELECT o FROM OrderListThisMonth o");
        return q.getResultList();
    }
    
    @Override
    public List<Orders> CustomerReport(String cus_id, Date startDate, Date endDate) {
        Query q=em.createQuery("SELECT o FROM Orders o WHERE o.customerID.customerID = :cus and o.orderDate >= :startDate and o.orderDate <= :endDate");
        q.setParameter("cus", cus_id);
        q.setParameter("startDate", startDate);
        q.setParameter("endDate", endDate);
        return q.getResultList();
    }

    @Override
    public List<Orders> AllOrderByCusID(String cusID) {
        Query q=em.createQuery("SELECT o FROM Orders o WHERE o.customerID.customerID = :cusID");
        q.setParameter("cusID", cusID);
        return q.getResultList();
    }
    
    public List<Orders> DateRangeReport(Date startDate, Date endDate) {
        Query q=em.createQuery("SELECT o FROM Orders o WHERE o.orderDate >= :startDate and o.orderDate <= :endDate");
        q.setParameter("startDate", startDate);
        q.setParameter("endDate", endDate);
        return q.getResultList();
    }
}
