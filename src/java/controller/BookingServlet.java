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


public class BookingServlet extends HttpServlet {
    private final CarDAO carDAO = new CarDAO();
    private final BookingDAO bookingDAO = new BookingDAO();

    // ✅ Xử lý GET: hiển thị danh sách xe đã đặt
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String username = getUsernameFromSession(session);
        loadBookingPage(req, resp, username);
    }

    // ✅ Xử lý POST: đặt xe và chuyển đến booking.jsp
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String username = getUsernameFromSession(session);
        String carIdParam = req.getParameter("carId");

        if (carIdParam != null && !carIdParam.isEmpty()) {
            try {
                int carId = Integer.parseInt(carIdParam);

                if (bookingDAO.hasUserBooked(username)) {
                    req.setAttribute("error", "Bạn đã đặt xe rồi. Mỗi người chỉ được đặt 1 xe.");
                } else {
                    boolean success = carDAO.bookCar(carId);
                    if (success) {
                        bookingDAO.saveBooking(username, carId);
                        req.setAttribute("message", "Đặt xe thành công!");
                    } else {
                        req.setAttribute("error", "Xe không còn trống.");
                    }
                }
            } catch (NumberFormatException e) {
                req.setAttribute("error", "ID xe không hợp lệ.");
            }
        } else {
            req.setAttribute("error", "Thiếu thông tin xe.");
        }

        loadBookingPage(req, resp, username);
    }

    // ✅ Hàm hiển thị danh sách xe đã đặt
    private void loadBookingPage(HttpServletRequest req, HttpServletResponse resp, String username)
            throws ServletException, IOException {

        List<Car> cars = carDAO.getAllCars();
        List<Booking> myBookings = bookingDAO.getBookingsByUser(username);

        req.setAttribute("cars", cars);
        req.setAttribute("myBookings", myBookings);
        req.getRequestDispatcher("user/booking.jsp").forward(req, resp);
    }

    // ✅ Hàm lấy username an toàn từ session
    private String getUsernameFromSession(HttpSession session) {
        Object userObj = session.getAttribute("user");
        return (userObj instanceof String) ? (String) userObj : null;
    }
}