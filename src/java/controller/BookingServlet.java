/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BookingDAO;
import dao.CarDAO;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import model.Booking;
import model.Car;


/**
 *
 * @author PC
 */

public class BookingServlet extends HttpServlet {
    private CarDAO carDAO = new CarDAO();
    private BookingDAO bookingDAO = new BookingDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("user");
        int carId = Integer.parseInt(req.getParameter("carId"));

        boolean success = carDAO.bookCar(carId);
        if (success) {
            bookingDAO.saveBooking(username, carId);
        }

        List<Car> cars = carDAO.getAllCars();
        List<Booking> myBookings = bookingDAO.getBookingsByUser(username);

        req.setAttribute("cars", cars);
        req.setAttribute("myBookings", myBookings);
        req.getRequestDispatcher("user/booking.jsp").forward(req, resp);
    }
}