/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.ProductsDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Duy
 */
@Local
public interface ProductsDetailsFacadeLocal {

    void create(ProductsDetails productsDetails);

    void edit(ProductsDetails productsDetails);

    void remove(ProductsDetails productsDetails);

    ProductsDetails find(Object id);

    List<ProductsDetails> findAll();

    List<ProductsDetails> findRange(int[] range);

    int count();

    List<ProductsDetails> FindProductDetailsByProID(String productID);
    
}
