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
import javax.ejb.Local;

/**
 *
 * @author Duy
 */
@Local
public interface OrdersFacadeLocal {

    void create(Orders orders);

    void edit(Orders orders);

    void remove(Orders orders);

    Orders find(Object id);

    List<Orders> findAll();

    List<Orders> findRange(int[] range);

    int count();

    List<OrderListThisMonth> OrderListThisMonth();
    
    List<Orders> CustomerReport(String cus_id, Date startDate, Date endDate);

    List<Orders> AllOrderByCusID(String cusID);
    
    List<Orders> DateRangeReport(Date startDate, Date endDate);
}
