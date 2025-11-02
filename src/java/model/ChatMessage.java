/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
package model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="chat_messages")
public class ChatMessage {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String sender;
    @Lob private String message;
    private LocalDateTime timestamp;

    public ChatMessage() {}
    public ChatMessage(String sender,String message){
        this.sender=sender; this.message=message; this.timestamp=LocalDateTime.now();
    }
    // getters/setters
    public int getId(){return id;}
    public String getSender(){return sender;} public void setSender(String s){this.sender=s;}
    public String getMessage(){return message;} public void setMessage(String m){this.message=m;}
    public LocalDateTime getTimestamp(){return timestamp;} public void setTimestamp(LocalDateTime t){this.timestamp=t;}
}
