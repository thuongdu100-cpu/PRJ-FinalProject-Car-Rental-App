/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author PC
 */
import model.ChatMessage; import util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ChatDAO implements IChatDAO {

    @Override
    public void save(ChatMessage m) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    @Override
    public List<ChatMessage> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM ChatMessage c ORDER BY c.timestamp", ChatMessage.class)
                     .getResultList();
        } finally { em.close(); }
    }
}