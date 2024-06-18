/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xigma_hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.*;

/**
 *
 * @author VIVOBOOK
 */

@Entity
@Table(name="student")
@PrimaryKeyJoinColumn(name="user_id")
public class Student extends User{
    
    @Column(name="student_id",nullable=false, unique=true)
    private String studentId;
    
    @Column(name="gpa")
    private String gpa;
    
    @ManyToMany(mappedBy = "students")
    private Set<Class> classes = new HashSet<>();
    
    @OneToMany(mappedBy = "student")
    private Set<Score> scores= new HashSet<>();
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "student_transcripts", joinColumns = @JoinColumn(name = "student_id"))
    private List<Transcript> transcripts = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supervisor_id")
    private Teacher supervisor;
    
    @ManyToMany(mappedBy = "attendees")
    private Set<Meeting> meetings = new HashSet<>();
    
    @ManyToMany(mappedBy = "assignees")
    private Set<Assignment> assignments = new HashSet<>();
    
    public Student(String username, String password, String studentId) {
        super(username, password);
        this.studentId = studentId;
    }
    
//    public void printTranscripts() {
//        if (transcripts != null && !transcripts.isEmpty()) {
//            for (Transcript transcript : transcripts) {
//                System.out.println("Course: " + transcript.getCourseId() + 
//                                   ", Course Name: " + transcript.getName() + 
//                                   ", Score: " + transcript.getScore());
//            }
//        } else {
//            System.out.println("No transcripts available for this student.");
//        }
//    }
    
    /**
     * @return the transcripts
     */
    public List<Transcript> getTranscripts() {
//        if (transcripts != null) {
//            for (Transcript transcript : transcripts) {
//                System.out.println("Course: " + transcript.getCourseId() + ", Course Name: " + transcript.getName() + ", Score: " + transcript.getScore());
//            }
//        } else {
//            System.out.println("No transcripts available for this student.");
//        }
        return transcripts;
    }
    
    //zihan
    public String getGpa(){
        return gpa;
    }
    
    public void setGpa(String gpa){
        this.gpa = gpa;
    }
    //zihan

    /**
     * @return the studentId
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * @return the classes
     */
    public Set<Class> getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    /**
     * @return the score
     */
    public Set<Score> getScores() {
        return scores;
    }

    /**
     * @param scores the scores to set
     */
    public void setScore(Set<Score> scores) {
        this.setScores(scores);
    }

    /**
     * @param scores the scores to set
     */
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }


    /**
     * @param transcripts the transcripts to set
     */
    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    /**
     * @return the supervisor
     */
    public Teacher getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(Teacher supervisor) {
        this.supervisor = supervisor;
    }
    
    /*Zihan*/
    public double calculateGPA() {
        double totalGradePoints = 0.0;
        int totalCourses = scores.size();

        for (Score score : scores) {
            totalGradePoints += convertScoreToGradePoint(score.getScore());
        }
        
        if (totalCourses > 0) {
            double gpa = totalGradePoints / totalCourses;
            this.gpa = convertGradePointToLetter(gpa);
        } else {
            this.gpa = "N/A";
        }

        return totalGradePoints / totalCourses;
    }
    
    private double convertScoreToGradePoint(int score) {
        if (score >= 90) {
            return 4.0; // A
        } else if (score >= 85) {
            return 3.7; // A-
        } else if (score >= 80) {
            return 3.3; // B+
        } else if (score >= 75) {
            return 3.0; // B
        } else if (score >= 70) {
            return 2.7; // B-
        } else if (score >= 65) {
            return 2.3; // C+
        } else if (score >= 60) {
            return 2.0; // C
        } else if (score >= 55) {
            return 1.7; // C-
        } else if (score >= 50) {
            return 1.0; // D
        } else {
            return 0.0; // E
        }
    }
    
    private String convertGradePointToLetter(double gpa) {
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
    
    public void printTranscript() {
        System.out.printf("%-15s %-20s %-5s%n", "courseId", "name", "score");
        for (Transcript transcript : transcripts) {
            System.out.printf("%-15s %-20s %-5d%n", transcript.getCourseId(), transcript.getName(), transcript.getScore());
        }
    }
    /*Zihan*/
     
}
