/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.AverageRatings;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Duy
 */
@Local
public interface AverageRatingsFacadeLocal {

    void create(AverageRatings averageRatings);

    void edit(AverageRatings averageRatings);

    void remove(AverageRatings averageRatings);

    AverageRatings find(Object id);

    List<AverageRatings> findAll();

    List<AverageRatings> findRange(int[] range);

    int count();
    
}
