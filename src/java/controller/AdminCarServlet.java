/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CarDAO;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Car;


/**
 *
 * @author PC
 */

public class AdminCarServlet extends HttpServlet {
    private final CarDAO dao = new CarDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("edit".equals(action)) {
            showEditForm(req, resp);
        } else if ("add".equals(action)) {
            showAddForm(req, resp);
        } else if ("delete".equals(action)) {
            deleteCar(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/CarServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        double price = Double.parseDouble(req.getParameter("price"));
        boolean available = req.getParameter("available") != null;

        if (id == null || id.isEmpty()) {
            // Thêm xe mới
            Car car = new Car(name, brand, price, available);
            dao.save(car);
        } else {
            // Cập nhật xe
            int carId = Integer.parseInt(id);
            Car car = dao.findById(carId);
            if (car != null) {
                car.setName(name);
                car.setBrand(brand);
                car.setPricePerDay(price);
                car.setAvailable(available);
                dao.update(car);
            }
        }

        // Sau khi lưu, quay lại form thêm xe
        resp.sendRedirect(req.getContextPath() + "/adminCarServlet?action=add");
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("car", null); // Form trống
        req.getRequestDispatcher("/admin/carForm.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Car car = dao.findById(id);
        req.setAttribute("car", car);
        req.getRequestDispatcher("/admin/carForm.jsp").forward(req, resp);
    }

    private void deleteCar(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/adminCarServlet?action=add");
    }
}