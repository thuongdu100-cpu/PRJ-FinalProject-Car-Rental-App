/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author PC
 */
import model.Car;
import java.util.List;

public interface ICarDAO {
    boolean bookCar(int carId);
    List<Car> getBookedCarsByUser(String username);
    List<Car> getAllCars();
    Car findById(int id);
    void save(Car c);
    void update(Car c);
    void delete(int id);
}
