/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.AverageRatings;
import entity.Products;
import entity.Report;
import entity.TopRatingThisYear;
import entity.TopSellingThisYear;
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
public class ProductsFacade extends AbstractFacade<Products> implements ProductsFacadeLocal {
    @PersistenceContext(unitName = "dntShop_ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }
    
    @Override
    public List<Products> AllProductByCategory(String cateid) {
        Query q = getEntityManager().createQuery("SELECT p FROM Products p WHERE p.categoryID.categoryID = :cateid and p.isStatus = :status");
        q.setParameter("cateid", cateid);
        boolean status=true;
        q.setParameter("status", status);
        return q.getResultList();
    }

    @Override
    public List<Products> AllProductByBrand(String brandid) {
        Query q = getEntityManager().createQuery("SELECT p FROM Products p WHERE p.brandID.brandID = :brandid and p.isStatus = :status");
        q.setParameter("brandid", brandid);
        boolean status=true;
        q.setParameter("status", status);
        return q.getResultList();
    }

    @Override
    public List<Products> AllProduct() {
        Query q = getEntityManager().createQuery("SELECT p FROM Products p WHERE p.isStatus = :status");
        boolean status=true;
        q.setParameter("status", status);
        return q.getResultList();
    }

    @Override
    public List<Products> AllProductNew() {
        Query q = getEntityManager().createQuery("SELECT p FROM Products p WHERE p.isStatus = :status and p.feature = :feat");
        boolean status=true;
        q.setParameter("status", status);
        q.setParameter("feat", "New");   
        return q.getResultList();
    }

    @Override
    public List<TopSellingThisYear> TopSellingThisYear() {
        Query q = getEntityManager().createQuery("SELECT t FROM TopSellingThisYear t");
        return q.getResultList();
    }

    @Override
    public List<TopRatingThisYear> TopRatingThisYear() {
        Query q = getEntityManager().createQuery("SELECT t FROM TopRatingThisYear t");
        return q.getResultList();
    }
    
    @Override
    public List<Report> ProductReport(String pro_id, Date startDate, Date endDate) {
        Query q=em.createQuery("SELECT r FROM Report r WHERE r.productID = :pro and r.orderDate >= :startDate and r.orderDate <= :endDate");
        q.setParameter("pro", pro_id);
        q.setParameter("startDate", startDate);
        q.setParameter("endDate", endDate);
        return q.getResultList();
    }
    
    @Override
    public List<Products> AllProductByPrice(float min, float max) {
        Query q = getEntityManager().createQuery("SELECT p FROM Products p WHERE p.price*(100-p.discountProduct)/100 >= :min and p.price*(100-p.discountProduct)/100 <= :max and p.isStatus = :status ORDER BY p.price*(100-p.discountProduct)/100");
        q.setParameter("min", min);
        q.setParameter("max", max);
        boolean status=true;
        q.setParameter("status", status);
        return q.getResultList();
    }

    @Override
    public List<Products> SearchProductByName(String proName) {
        Query q = getEntityManager().createQuery("SELECT p FROM Products p WHERE p.productName LIKE :proName and p.isStatus = :status");
        q.setParameter("proName", "%"+proName+"%");
        boolean status=true;
        q.setParameter("status", status);
        return q.getResultList();
    }

    @Override
    public List<AverageRatings> AverageRatingsProductID(String proid) {
        Query q = getEntityManager().createQuery("SELECT a FROM AverageRatings a WHERE a.productID = :proid");
        q.setParameter("proid", proid);
        return q.getResultList();
    }
    
}
