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
import javax.ejb.Local;

/**
 *
 * @author Duy
 */
@Local
public interface ProductsFacadeLocal {

    void create(Products products);

    void edit(Products products);

    void remove(Products products);

    Products find(Object id);

    List<Products> findAll();

    List<Products> findRange(int[] range);

    int count();
    
    List<Products> AllProductByCategory(String cateid);

    List<Products> AllProductByBrand(String brandid);

    List<Products> AllProduct();

    List<Products> AllProductNew();

    List<TopSellingThisYear> TopSellingThisYear();

    List<TopRatingThisYear> TopRatingThisYear();
    
    List<Report> ProductReport(String pro_id, Date startDate, Date endDate);
    
    List<Products> AllProductByPrice(float min, float max);

    List<Products> SearchProductByName(String proName);

    List<AverageRatings> AverageRatingsProductID(String proid);
}
