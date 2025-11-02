/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CarDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Car;


/**
 *
 * @author PC
 */
@WebServlet(name = "AdminCarServlet", urlPatterns = {"/adminCarServlet"})
public class AdminCarServlet extends HttpServlet {
    private CarDAO dao = new CarDAO();
    @Override protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        String action = req.getParameter("action");
        if("edit".equals(action)){
            int id=Integer.parseInt(req.getParameter("id"));
            req.setAttribute("car", dao.findById(id));
            req.getRequestDispatcher("/admin/carForm.jsp").forward(req,resp);
            return;
        } else if("delete".equals(action)){
            int id=Integer.parseInt(req.getParameter("id"));
            dao.delete(id);
            resp.sendRedirect(req.getContextPath()+"/admin/car");
            return;
        }
        req.setAttribute("cars", dao.getAllCars());
        req.getRequestDispatcher("/admin/carList.jsp").forward(req,resp);
    }

    @Override protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        String name = req.getParameter("name"); String brand=req.getParameter("brand"); double price = Double.parseDouble(req.getParameter("price"));
        String id = req.getParameter("id");
        if(id==null || id.isEmpty()){
            dao.save(new Car(name, brand, price, true));
        } else {
            Car c = dao.findById(Integer.parseInt(id));
            c.setName(name); c.setBrand(brand); c.setPricePerDay(price);
            dao.update(c);
        }
        resp.sendRedirect(req.getContextPath()+"/admin/car");
    }
}