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
import xigma_hibernate.Student;
import xigma_hibernate.Transcript;

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

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        
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
        
        Teacher teacher2 = new Teacher("layla", "12345", "0102030406");
        session.save(teacher2);
        
        Course course1 = new Course("PBO", "ILK010101");
        session.save(course1);
        
        Course course2 = new Course("JARKOM", "ILK010102");
        session.save(course2);
        
        Class class1 = new Class("KOM A");
        class1.setTeacher(teacher1);
        class1.setCourse(course1);
        class1.getStudents().add(student1);
        class1.getStudents().add(student2);
        class1.getStudents().add(student3);
        session.save(class1);
        
        Class class2 = new Class("KOM B");
        class2.setTeacher(teacher2);
        class2.setCourse(course2);
        class2.getStudents().add(student1);
        class2.getStudents().add(student2);
        class2.getStudents().add(student3);
        session.save(class2);
        
        Score score1 = new Score(98);
        score1.setClasses(class1);
        score1.setStudent(student1);
        score1.setCourse(course1);
        session.save(score1);
        
        Score score2 = new Score(88);
        score2.setClasses(class2);
        score2.setStudent(student1);
        score2.setCourse(course2);
        session.save(score2);
        
        Score score3 = new Score(68);
        score3.setClasses(class1);
        score3.setStudent(student2);
        score3.setCourse(course1);
        session.save(score3);
        
        Score score4 = new Score(74);
        score4.setClasses(class2);
        score4.setStudent(student2);
        score4.setCourse(course2);
        session.save(score4);
        
        Score score5 = new Score(54);
        score5.setClasses(class1);
        score5.setStudent(student3);
        score5.setCourse(course1);
        session.save(score5);
        
        Score score6 = new Score(48);
        score6.setClasses(class2);
        score6.setStudent(student3);
        score6.setCourse(course2);
        session.save(score6);
        
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
        
        /*Zihan*/
        
        // Calculate and save GPA for each student
        session.beginTransaction();
        updateAndSaveGPA(session);
        session.getTransaction().commit();
        
        // Print GPA table
        session.beginTransaction();
        printGPATable(session);
        session.getTransaction().commit();

        
        displayActivityMeeting(meeting1);
        
        Transcript transcript1 = new Transcript("C101", "Mathematics", 95);
        Transcript transcript2 = new Transcript("C102", "Science", 88);

        List<Transcript> transcripts = new ArrayList<>();
        transcripts.add(transcript1);
        transcripts.add(transcript2);
        student1.setTranscripts(transcripts);

        session.beginTransaction();
        student1.getTranscripts();
        session.update(student1);
        session.getTransaction().commit();
            
            // Print student1's transcripts
            System.out.println("Transcripts for Student 1:");
            student1.printTranscript();

        
        try {
            
            // Query all students and their transcripts
            List<Student> students = session.createQuery("FROM Student", Student.class).list();
            
            // Commit the transaction
            transaction.commit();
            
            // Print all transcripts to the console
            for (Student student : students) {
                for (Transcript transcript : student.getTranscripts()) {
                    System.out.println("Student ID: " + student.getStudentId() +
                                       ", Course: " + transcript.getCourseId() +
                                       ", Course Name: " + transcript.getName() +
                                       ", Score: " + transcript.getScore());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close(); // Close the session when done
            factory.close(); // Close the session factory when done
        }
        
        session.close();
        
    }
    
    private static void updateAndSaveGPA(Session session) {
        List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();
        for (Student student : students) {
            calculateAndSetGPA(session, student);
        }
    }
    
    private static void calculateAndSetGPA(Session session, Student student) {
        List<Score> scores = session.createQuery("FROM Score WHERE student.id = :studentId", Score.class)
                                    .setParameter("studentId", student.getId())
                                    .getResultList();

        if (scores == null || scores.isEmpty()) {
            student.setGpa("E");
        } else {
            double totalScore = 0.0;
            for (Score score : scores) {
                totalScore += score.getScore();
            }
            double gpaValue = totalScore / scores.size();
            student.setGpa(String.format("%.2f",gpaValue));
            student.setGpa(convertGradePointToLetter(gpaValue));
        }
        session.update(student);
    }
    
    private static String convertGradePointToLetter(double gpa) {
        if (gpa >= 4.0) {
            return "A";
        } else if (gpa >= 3.7) {
            return "A-";
        } else if (gpa >= 3.3) {
            return "B+";
        } else if (gpa >= 3.0) {
            return "B";
        } else if (gpa >= 2.7) {
            return "B-";
        } else if (gpa >= 2.3) {
            return "C+";
        } else if (gpa >= 2.0) {
            return "C";
        } else if (gpa >= 1.7) {
            return "C-";
        } else if (gpa >= 1.0) {
            return "D";
        } else {
            return "E";
        }
    }
    
    private static void printGPATable(Session session) {
        List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();

        System.out.println("+----------------+------+\n| Student ID     | GPA  |\n+----------------+------+");
        for (Student student : students) {
            System.out.printf("| %-14s | %-4s |\n", student.getStudentId(), student.getGpa());
        }
        System.out.println("+----------------+------+");
    }

    
    private static void displayActivityMeeting(Meeting meeting) {
            System.out.println("meeting : \n" + meeting.getDescription() + "\n" + meeting.getAttendees());
    }
    
    private static void displayActivityAssignment(Assignment assignment) {
            System.out.println("meeting : \n" + assignment.getDescription() + "\n" + assignment.getAssignees());
    }
    

}
