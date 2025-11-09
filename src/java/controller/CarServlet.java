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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;
import model.Car;


/**
 *
 * @author PC
 */

public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Car> cars = new CarDAO().getAllCars();
        req.setAttribute("cars", cars);    
        HttpSession session = req.getSession(false);
        String role = "guest";
  
        if (session != null && session.getAttribute("user") != null) {
            role = "user";         
        }

        req.setAttribute("role", role);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
