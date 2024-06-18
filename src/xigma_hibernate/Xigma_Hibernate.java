/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xigma_hibernate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        
        Student student3 = new Student("alya","12345","221401003");
        session.save(student3);
        
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
        
//        Transcript transcript1 = new Transcript(course1,course1);
//        transcript1.setStudent(student1);
//        session.save(transcript1);
                
//        student1.getTranscripts().add(transcript1);
//        session.update(student1);
        
        //Fathya test Meeting
        Meeting meeting1 = new Meeting();
        meeting1.setMeetingStartTime(LocalDateTime.now());
        meeting1.setMyClass(class1);
        meeting1.setTeacher(teacher1);
        meeting1.setCourse(course1);
        
        Set<Student> attendees = new HashSet<>();
        attendees.add(student2);
        attendees.add(student3);
        meeting1.setAttendees(attendees);
        
        session.save(meeting1);
        
        //test Assignment
        Assignment assignment1 = new Assignment();
        assignment1.setMyClass(class1);
        assignment1.setTeacher(teacher1);
        assignment1.setCourse(course1);
        assignment1.setDueDate(LocalDateTime.now().plusDays(7));
        
        Set<Student> assignees = new HashSet<>();
        assignees.add(student1);
        assignees.add(student2);
        assignment1.setAssignees(assignees);
        
        session.save(assignment1);
        
        transaction.commit();
        session.close();
        
        /*Zihan*/
        Score score1_1 = new Score(88);
        score1_1.setStudent(student1);
        Score score1_2 = new Score(76);
        score1_2.setStudent(student1);
        Score score1_3 = new Score(91);
        score1_3.setStudent(student1);
        student1.getScores().add(score1_1);
        student1.getScores().add(score1_2);
        student1.getScores().add(score1_3);
        
        Score score2_1 = new Score(68);
        score2_1.setStudent(student2);
        Score score2_2 = new Score(74);
        score2_2.setStudent(student2);
        Score score2_3 = new Score(82);
        score2_3.setStudent(student2);
        student2.getScores().add(score2_1);
        student2.getScores().add(score2_2);
        student2.getScores().add(score2_3);
        
        Score score3_1 = new Score(54);
        score3_1.setStudent(student3);
        Score score3_2 = new Score(48);
        score3_2.setStudent(student3);
        Score score3_3 = new Score(72);
        score3_3.setStudent(student3);
        student3.getScores().add(score3_1);
        student3.getScores().add(score3_2);
        student3.getScores().add(score3_3);
        
        // Save students and scores to the database
        session.save(student1);
        session.save(score1_1);
        session.save(score1_2);
        session.save(score1_3);

        session.save(student2);
        session.save(score2_1);
        session.save(score2_2);
        session.save(score2_3);

        session.save(student3);
        session.save(score3_1);
        session.save(score3_2);
        session.save(score3_3);

        transaction.commit();
        
         // Fetch and display GPA for each student
        displayStudentGPA(session, student1.getId());
        displayStudentGPA(session, student2.getId());
        displayStudentGPA(session, student3.getId());
        
        displayActivityMeeting(meeting1);
        
    }

    private static void displayStudentGPA(Session session, int studentId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
        Student student = session.get(Student.class, studentId);
        if (student != null){
            System.out.println(student.getStudentId() + "'s GPA: " + student.calculateGPA());
        }else{
            System.out.println("Student not found");
        }
    }
    
    private static void displayActivityMeeting(Meeting meeting) {
            System.out.println("meeting : \n" + meeting.getDescription() + "\n" + meeting.getAttendees());
    }
    
    private static void displayActivityAssignment(Assignment assignment) {
            System.out.println("meeting : \n" + assignment.getDescription() + "\n" + assignment.getAssignees());
    }
    

}
