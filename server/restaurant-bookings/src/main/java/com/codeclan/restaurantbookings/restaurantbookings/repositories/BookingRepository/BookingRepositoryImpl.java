package com.codeclan.restaurantbookings.restaurantbookings.repositories.BookingRepository;

import com.codeclan.restaurantbookings.restaurantbookings.models.Booking;
import com.codeclan.restaurantbookings.restaurantbookings.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class BookingRepositoryImpl implements BookingRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    public List<Booking> getAllBookingsForDate(Date date) {
//        List<Booking> results = null;
//
//        Session session = entityManager.unwrap(Session.class);
//        try{
//            Criteria cr = session.createCriteria(Booking.class);
//            cr.add(Restrictions.eq("date", date));
//            results = cr.list();
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//        }
//        return results;
//    }

    public List<Booking> getBookingByDateTimeAndCustomerId(Date date, String time, Customer customerId) {
        List<Booking> result = null;

        Session session = entityManager.unwrap(Session.class);
        try{
            Criteria cr = session.createCriteria(Booking.class);
            cr.add(Restrictions.eq("date", date));
            cr.add(Restrictions.eq("time", time));
            cr.add(Restrictions.eq("customer", customerId));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
