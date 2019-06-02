package entity;

import entity.OrderListThisMonth;
import entity.Orders;
import entity.Ratings;
import entity.Wishlist;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, String> lastName;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, String> avatar;
    public static volatile SingularAttribute<Customers, String> password;
    public static volatile CollectionAttribute<Customers, Ratings> ratingsCollection;
    public static volatile SingularAttribute<Customers, Boolean> isStatus;
    public static volatile CollectionAttribute<Customers, Wishlist> wishlistCollection;
    public static volatile SingularAttribute<Customers, String> email;
    public static volatile SingularAttribute<Customers, String> address;
    public static volatile SingularAttribute<Customers, Boolean> gender;
    public static volatile CollectionAttribute<Customers, OrderListThisMonth> orderListThisMonthCollection;
    public static volatile SingularAttribute<Customers, String> firstName;
    public static volatile SingularAttribute<Customers, String> customerID;
    public static volatile CollectionAttribute<Customers, Orders> ordersCollection;
    public static volatile SingularAttribute<Customers, Date> createdDate;

}