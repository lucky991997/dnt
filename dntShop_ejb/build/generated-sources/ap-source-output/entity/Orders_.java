package entity;

import entity.Customers;
import entity.OrdersDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Integer> total;
    public static volatile SingularAttribute<Orders, String> shipPhone;
    public static volatile SingularAttribute<Orders, String> orderID;
    public static volatile SingularAttribute<Orders, String> processStatus;
    public static volatile SingularAttribute<Orders, Date> orderDate;
    public static volatile SingularAttribute<Orders, String> shipName;
    public static volatile SingularAttribute<Orders, Date> shipDate;
    public static volatile SingularAttribute<Orders, Boolean> isStatus;
    public static volatile SingularAttribute<Orders, String> shipNote;
    public static volatile CollectionAttribute<Orders, OrdersDetails> ordersDetailsCollection;
    public static volatile SingularAttribute<Orders, String> shipAddress;
    public static volatile SingularAttribute<Orders, Customers> customerID;
    public static volatile SingularAttribute<Orders, String> paymentMethod;

}