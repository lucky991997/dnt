package entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2019-05-14T20:21:01")
@StaticMetamodel(Admins.class)
public class Admins_ { 

    public static volatile SingularAttribute<Admins, String> adminID;
    public static volatile SingularAttribute<Admins, String> email;
    public static volatile SingularAttribute<Admins, String> fullName;
    public static volatile SingularAttribute<Admins, String> avatar;
    public static volatile SingularAttribute<Admins, String> password;
    public static volatile SingularAttribute<Admins, Date> createdDate;
    public static volatile SingularAttribute<Admins, Boolean> isStatus;

}