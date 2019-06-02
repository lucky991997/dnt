package entity;

import entity.Customers;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(OrderListThisMonth.class)
public class OrderListThisMonth_ { 

    public static volatile SingularAttribute<OrderListThisMonth, Integer> total;
    public static volatile SingularAttribute<OrderListThisMonth, String> shipPhone;
    public static volatile SingularAttribute<OrderListThisMonth, String> orderID;
    public static volatile SingularAttribute<OrderListThisMonth, String> shipNote;
    public static volatile SingularAttribute<OrderListThisMonth, String> processStatus;
    public static volatile SingularAttribute<OrderListThisMonth, Date> orderDate;
    public static volatile SingularAttribute<OrderListThisMonth, String> shipName;
    public static volatile SingularAttribute<OrderListThisMonth, String> shipAddress;
    public static volatile SingularAttribute<OrderListThisMonth, Date> shipDate;
    public static volatile SingularAttribute<OrderListThisMonth, Customers> customerID;
    public static volatile SingularAttribute<OrderListThisMonth, String> paymentMethod;
    public static volatile SingularAttribute<OrderListThisMonth, Boolean> isStatus;

}