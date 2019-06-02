/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Wishlist;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Duy
 */
@Local
public interface WishlistFacadeLocal {

    void create(Wishlist wishlist);

    void edit(Wishlist wishlist);

    void remove(Wishlist wishlist);

    Wishlist find(Object id);

    List<Wishlist> findAll();

    List<Wishlist> findRange(int[] range);

    int count();

    List<Wishlist> findbyCustomer(String cusId);

    List<Wishlist> findbyProduct(String productId,String cusId);
    
}
