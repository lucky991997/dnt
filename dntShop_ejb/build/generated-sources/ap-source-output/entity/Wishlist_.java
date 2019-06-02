package entity;

import entity.Customers;
import entity.Products;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(Wishlist.class)
public class Wishlist_ { 

    public static volatile SingularAttribute<Wishlist, Integer> wishlistID;
    public static volatile SingularAttribute<Wishlist, Date> dateCreated;
    public static volatile SingularAttribute<Wishlist, Customers> customerID;
    public static volatile SingularAttribute<Wishlist, Products> productID;

}