/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xigma_hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VIVOBOOK
 */
public class Xigma_Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        User user = new User ("ninja","12345");
        session.save(user);
        
        transaction.commit();
        
        session.close();
    }
    
    
}
