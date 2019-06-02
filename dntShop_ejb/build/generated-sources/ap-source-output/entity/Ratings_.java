package entity;

import entity.Customers;
import entity.Products;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(Ratings.class)
public class Ratings_ { 

    public static volatile SingularAttribute<Ratings, String> content;
    public static volatile SingularAttribute<Ratings, Integer> ratingID;
    public static volatile SingularAttribute<Ratings, Integer> rate;
    public static volatile SingularAttribute<Ratings, Date> ratingDate;
    public static volatile SingularAttribute<Ratings, Customers> customerID;
    public static volatile SingularAttribute<Ratings, Products> productID;

}