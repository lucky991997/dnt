package entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(AverageRatings.class)
public class AverageRatings_ { 

    public static volatile SingularAttribute<AverageRatings, BigInteger> id;
    public static volatile SingularAttribute<AverageRatings, BigDecimal> averageRating;
    public static volatile SingularAttribute<AverageRatings, Integer> star;
    public static volatile SingularAttribute<AverageRatings, String> productID;
    public static volatile SingularAttribute<AverageRatings, String> productName;

}