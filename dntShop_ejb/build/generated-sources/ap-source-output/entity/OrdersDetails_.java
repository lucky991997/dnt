package entity;

import entity.Orders;
import entity.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(OrdersDetails.class)
public class OrdersDetails_ { 

    public static volatile SingularAttribute<OrdersDetails, Integer> sellingPrice;
    public static volatile SingularAttribute<OrdersDetails, Orders> orderID;
    public static volatile SingularAttribute<OrdersDetails, Integer> odID;
    public static volatile SingularAttribute<OrdersDetails, Integer> quantity;
    public static volatile SingularAttribute<OrdersDetails, Products> productID;
    public static volatile SingularAttribute<OrdersDetails, Boolean> isStatus;

}