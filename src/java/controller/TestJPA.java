/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import jakarta.persistence.EntityManager;
import model.Car;
import util.JPAUtil;

public class TestJPA {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Car car = new Car("Vios", "Toyota", 1200, true);
        em.persist(car);
        em.getTransaction().commit();
        em.close();
        System.out.println(" Lưu thành công!");
    }
}
