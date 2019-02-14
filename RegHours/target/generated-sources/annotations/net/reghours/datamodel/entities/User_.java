package net.reghours.datamodel.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.reghours.datamodel.entities.Timerecord;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-14T02:28:04")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, Timerecord> timerecordCollection;
    public static volatile SingularAttribute<User, String> firstname;
    public static volatile SingularAttribute<User, String> passwd;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> lastname;

}