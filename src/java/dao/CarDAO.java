/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Car; import util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CarDAO implements ICarDAO { 

    @Override
    public List<Car> getAllCars() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c", Car.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Car findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try { return em.find(Car.class, id); }
        finally { em.close(); }
    }

    @Override
    public void save(Car c) {
        EntityManager em = JPAUtil.getEntityManager();
        try { 
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit(); 
        } finally { em.close(); }
    }

    @Override
    public void update(Car c) {
        EntityManager em = JPAUtil.getEntityManager();
        try { 
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit(); 
        } finally { em.close(); }
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Car c = em.find(Car.class, id);
            if(c != null) em.remove(c);
            em.getTransaction().commit();
        } finally { em.close(); }
    }
    @Override
public boolean bookCar(int carId) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        em.getTransaction().begin();
        Car car = em.find(Car.class, carId);
        if (car != null && car.isAvailable()) {
            car.setAvailable(false);
            em.merge(car);
            em.getTransaction().commit();
            return true;
        }
        em.getTransaction().rollback();
        return false;
    } catch (Exception e) {
        em.getTransaction().rollback();
        e.printStackTrace();
        return false;
    } finally {
        em.close();
    }
}
    @Override
public List<Car> getBookedCarsByUser(String username) {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        String jpql = "SELECT b.car FROM Booking b WHERE b.username = :username";
        TypedQuery<Car> query = em.createQuery(jpql, Car.class);
        query.setParameter("username", username);
        return query.getResultList();
    } finally {
        em.close();
    }
}
}