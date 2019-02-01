package net.reghours.datamodel.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.reghours.datamodel.entities.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-02-01T18:44:53")
@StaticMetamodel(Timerecord.class)
public class Timerecord_ { 

    public static volatile SingularAttribute<Timerecord, Date> record;
    public static volatile SingularAttribute<Timerecord, Integer> idRecord;
    public static volatile SingularAttribute<Timerecord, String> type;
    public static volatile SingularAttribute<Timerecord, User> user;

}