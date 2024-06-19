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

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        
        User user = new User("ninja","12345");
        session.save(user);
    
        Student student1 = new Student("khaisa","12345","221401001");
        session.save(student1);
        Student student2 = new Student("shafa","12345","221401002");
        session.save(student2);
        Student student3 = new Student("alya","12345","221401003");
        session.save(student3);
        Student student4 = new Student("a","12345","221401004");
        session.save(student4);
        Student student5 = new Student("b","12345","221401005");
        session.save(student5);
        Student student6 = new Student("c","12345","221401006");
        session.save(student6);
        Student student7 = new Student("d","12345","221401007");
        session.save(student7);
        Student student8 = new Student("e","12345","221401008");
        session.save(student8);
        Student student9 = new Student("f","12345","221401009");
        session.save(student9);
        Student student10 = new Student("g","12345","2214010010");
        session.save(student10);
        Student student11 = new Student("h","12345","221401011");
        session.save(student11);
        Student student12 = new Student("i","12345","221401012");
        session.save(student12);
        Student student13 = new Student("j","12345","221401013");
        session.save(student13);
        Student student14 = new Student("k","12345","221401014");
        session.save(student14);
        Student student15 = new Student("l","12345","221401015");
        session.save(student15);
        Student student16 = new Student("m","12345","221401016");
        session.save(student16);
        Student student17 = new Student("n","12345","221401017");
        session.save(student17);
        Student student18 = new Student("o","12345","221401018");
        session.save(student18);
        Student student19 = new Student("p","12345","221401019");
        session.save(student19);
        Student student20 = new Student("q","12345","2214010020");
        session.save(student20);
        
        
        Teacher teacher1 = new Teacher("dewi", "12345", "0102030405");
        session.save(teacher1);    
        Teacher teacher2 = new Teacher("layla", "12345", "0102030406");
        session.save(teacher2);
        Teacher teacher3 = new Teacher("teacherA", "12345", "0102030407");
        session.save(teacher3);    
        Teacher teacher4 = new Teacher("teacherB", "12345", "0102030408");
        session.save(teacher4);

        Course course1 = new Course("PBO", "ILK010101");
        session.save(course1);
        Course course2 = new Course("JARKOM", "ILK010102");
        session.save(course2);
        Course course3 = new Course("KDI", "ILK010103");
        session.save(course3);
        Course course4 = new Course("ADPL", "ILK010104");
        session.save(course4);
        
        Class class1 = new Class("KOM A");
        class1.setTeacher(teacher1);
        class1.setCourse(course1);
        class1.getStudents().add(student1);
        class1.getStudents().add(student2);
        class1.getStudents().add(student3);
        class1.getStudents().add(student4);
        class1.getStudents().add(student5);
        session.save(class1);
        
        Class class2 = new Class("KOM B");
        class2.setTeacher(teacher2);
        class2.setCourse(course2);
        class2.getStudents().add(student6);
        class2.getStudents().add(student7);
        class2.getStudents().add(student8);
        class2.getStudents().add(student9);
        class2.getStudents().add(student10);
        session.save(class2);
        
        Class class3 = new Class("KOM C");
        class3.setTeacher(teacher3);
        class3.setCourse(course2);
        class3.getStudents().add(student11);
        class3.getStudents().add(student12);
        class3.getStudents().add(student13);
        class3.getStudents().add(student14);
        class3.getStudents().add(student15);
        session.save(class3);
        
        Class class4 = new Class("KOM D");
        class4.setTeacher(teacher3);
        class4.setCourse(course2);
        class4.getStudents().add(student16);
        class4.getStudents().add(student17);
        class4.getStudents().add(student18);
        class4.getStudents().add(student19);
        class4.getStudents().add(student20);
        session.save(class4);
        
        Score score1 = new Score(98);
        score1.setClasses(class1);
        score1.setStudent(student1);
        score1.setCourse(course1);
        session.save(score1);
        
        Score score2 = new Score(88);
        score2.setClasses(class1);
        score2.setStudent(student2);
        score2.setCourse(course2);
        session.save(score2);
        
        Score score3 = new Score(68);
        score3.setClasses(class1);
        score3.setStudent(student3);
        score3.setCourse(course3);
        session.save(score3);
        
        Score score4 = new Score(74);
        score4.setClasses(class1);
        score4.setStudent(student4);
        score4.setCourse(course2);
        session.save(score4);
        
        Score score5 = new Score(54);
        score5.setClasses(class1);
        score5.setStudent(student5);
        score5.setCourse(course1);
        session.save(score5);
        
        Score score6 = new Score(100);
        score6.setClasses(class2);
        score6.setStudent(student6);
        score6.setCourse(course2);
        session.save(score6);
        
        Score score7 = new Score(48);
        score7.setClasses(class2);
        score7.setStudent(student7);
        score7.setCourse(course1);
        session.save(score7);
        
        Score score8 = new Score(99);
        score8.setClasses(class2);
        score8.setStudent(student8);
        score8.setCourse(course2);
        session.save(score8);
        
        Score score9 = new Score(85);
        score9.setClasses(class2);
        score9.setStudent(student9);
        score9.setCourse(course3);
        session.save(score9);
        
        Score score10 = new Score(90);
        score10.setClasses(class2);
        score10.setStudent(student10);
        score10.setCourse(course4);
        session.save(score10);
        
        
        
        //test Meeting
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
        
        Meeting meeting2= new Meeting();
        meeting2.setMeetingStartTime(LocalDateTime.now());
        meeting2.setMyClass(class2);
        meeting2.setTeacher(teacher2);
        meeting2.setCourse(course2);
        
        Set<Student> attendees2 = new HashSet<>();
        attendees2.add(student7);
        attendees2.add(student8);
        attendees2.add(student10);
        meeting2.setAttendees(attendees2);
        
        session.save(meeting2);
        
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
        
        Assignment assignment2 = new Assignment();
        assignment2.setMyClass(class3);
        assignment2.setTeacher(teacher3);
        assignment2.setCourse(course3);
        assignment2.setDueDate(LocalDateTime.now().plusDays(7));
        
        Set<Student> assignees2 = new HashSet<>();
        assignees2.add(student1);
        assignees2.add(student2);
        assignment2.setAssignees(assignees2);
        
        session.save(assignment2);
        session.save(assignment1);
        
        transaction.commit();
        
        //Zihan/
        
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