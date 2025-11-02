/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Booking;

/**
 *
 * @author PC
 */
public interface IBookingDAO {
    void saveBooking(String username, int carId);
    List<Booking> getBookingsByUser(String username);
}