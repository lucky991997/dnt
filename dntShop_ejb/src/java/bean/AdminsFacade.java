/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Admins;
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
public class AdminsFacade extends AbstractFacade<Admins> implements AdminsFacadeLocal {
    @PersistenceContext(unitName = "dntShop_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminsFacade() {
        super(Admins.class);
    }
    
    @Override
    public List<Admins> login(String username, String password) {
        Query q = getEntityManager().createQuery("SELECT a FROM Admins a WHERE a.email = :username and a.password = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        return q.getResultList();
    }
}
