/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import entity.Customers;
import entity.Report;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Duy
 */
@Local
public interface CustomersFacadeLocal {

    void create(Customers customers);

    void edit(Customers customers);

    void remove(Customers customers);

    Customers find(Object id);

    List<Customers> findAll();

    List<Customers> findRange(int[] range);

    int count();

    List<Customers> login(String email, String pass);

    List<Customers> findByMail(String email);
    
}
