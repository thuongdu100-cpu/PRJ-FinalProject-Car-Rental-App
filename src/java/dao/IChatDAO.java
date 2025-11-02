/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

/**
 *
 * @author PC
 */
import model.ChatMessage;
import java.util.List;

public interface IChatDAO {
    void save(ChatMessage m);
    List<ChatMessage> getAll();
}
