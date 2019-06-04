package com.codeclan.restaurantbookings.restaurantbookings.repositories.CustomerRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom{

    @Autowired
    EntityManager entityManager;

//    @Transactional
//    public List<Customer> findAllOrderByBookingsCount() {
//        List<Customer> results = null;
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

}
