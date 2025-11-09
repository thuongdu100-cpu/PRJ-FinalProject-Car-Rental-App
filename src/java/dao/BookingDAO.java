/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import model.Booking;
import model.Car;
import util.JPAUtil;

/**
 *
 * @author PC
 */
public class BookingDAO implements IBookingDAO {

    @Override
    public void saveBooking(String username, int carId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Booking booking = new Booking();
            booking.setUsername(username);
            booking.setCar(em.find(Car.class, carId));
            booking.setBookingDate(LocalDateTime.now());
            booking.setStatus("Đã đặt");
            em.persist(booking);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Booking> getBookingsByUser(String username) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT b FROM Booking b WHERE b.username = :username";
            TypedQuery<Booking> query = em.createQuery(jpql, Booking.class);
            query.setParameter("username", username);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public boolean hasUserBooked(String username) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT COUNT(b) FROM Booking b WHERE b.username = :username";
            Long count = em.createQuery(jpql, Long.class)
                           .setParameter("username", username)
                           .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
}

