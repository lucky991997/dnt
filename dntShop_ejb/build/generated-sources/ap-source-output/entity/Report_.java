package entity;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(Report.class)
public class Report_ { 

    public static volatile SingularAttribute<Report, Integer> total;
    public static volatile SingularAttribute<Report, String> lastName;
    public static volatile SingularAttribute<Report, String> orderID;
    public static volatile SingularAttribute<Report, String> processStatus;
    public static volatile SingularAttribute<Report, Date> orderDate;
    public static volatile SingularAttribute<Report, String> shipName;
    public static volatile SingularAttribute<Report, Date> shipDate;
    public static volatile SingularAttribute<Report, String> productID;
    public static volatile SingularAttribute<Report, Integer> sellingPrice;
    public static volatile SingularAttribute<Report, Integer> quantity;
    public static volatile SingularAttribute<Report, String> firstName;
    public static volatile SingularAttribute<Report, String> customerID;
    public static volatile SingularAttribute<Report, BigInteger> rowid;
    public static volatile SingularAttribute<Report, String> productName;

}