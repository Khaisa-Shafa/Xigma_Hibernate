/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xigma_hibernate;

import java.util.ArrayList;
import java.util.List;
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

        User user = new User("ninja","12345");
        session.save(user);
    
        Student student1 = new Student("khaisa","12345","221401001");
        session.save(student1);
        
        Student student2 = new Student("shafa","12345","221401002");
        session.save(student2);
        
        Teacher teacher1 = new Teacher("dewi", "12345", "0102030405");
        session.save(teacher1);
        
        Course course1 = new Course("PBO", "ILK010101", "ppp");
        session.save(course1);
        
        Class class1 = new Class("KOM A");
        class1.setTeacher(teacher1);
        class1.setCourse(course1);
        class1.getStudents().add(student1);
        class1.getStudents().add(student2);
        session.save(class1);
        
        Score score1 = new Score(98);
        score1.setClasses(class1);
        score1.setStudent(student1);
        session.save(score1);
        
        Transcript transcript1 = new Transcript(course1,course1, 89);
        transcript1.setStudent(student1);
        session.save(transcript1);
                
        student1.getTranscripts().add(transcript1);
        session.update(student1);
        
        transaction.commit();
        session.close();
    }


}
