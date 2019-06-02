package entity;

import entity.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(Brands.class)
public class Brands_ { 

    public static volatile SingularAttribute<Brands, String> brandID;
    public static volatile SingularAttribute<Brands, String> brandImages;
    public static volatile CollectionAttribute<Brands, Products> productsCollection;
    public static volatile SingularAttribute<Brands, String> brandName;
    public static volatile SingularAttribute<Brands, String> descriptions;
    public static volatile SingularAttribute<Brands, Boolean> isStatus;

}