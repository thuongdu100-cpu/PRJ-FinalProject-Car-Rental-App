/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author PC
 */
public interface IUserDAO {
    void save(User user);
    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    List<User> getAllUsers();
    void update(User user);
    void delete(int id);
}
