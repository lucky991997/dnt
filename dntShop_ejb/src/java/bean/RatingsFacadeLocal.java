/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Ratings;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Duy
 */
@Local
public interface RatingsFacadeLocal {

    void create(Ratings ratings);

    void edit(Ratings ratings);

    void remove(Ratings ratings);

    Ratings find(Object id);

    List<Ratings> findAll();

    List<Ratings> findRange(int[] range);

    int count();

    List<Ratings> AllRatingByProductID(String proid);
    
}
