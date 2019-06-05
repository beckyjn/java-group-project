package com.codeclan.restaurantbookings.restaurantbookings.repositories.RestaurantTableRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.RestaurantTable;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class RestaurantTableRepositoryImpl implements RestaurantTableRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<RestaurantTable> getTablesAvailableOnDate(String date){
        List<RestaurantTable> results = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(RestaurantTable.class);
            results = cr.list();

        }
        catch(HibernateException ex) {
            ex.printStackTrace();
        }
        finally {
            session.close();
            return results;
        }
        }
    }
//        Session session = entityManager.unwrap(Session.class);
//        try {
//            Criteria cr = session.createCriteria(Customer.class);
//            cr.createAlias("bookings", "bookings");
//            cr.addOrder(Order.desc("count"));
//            results = cr.list();
//        }
//        catch(HibernateException ex) {
//            ex.printStackTrace();
//        }
//        finally {
//            session.close();
//            return results;
//        }
//    }



