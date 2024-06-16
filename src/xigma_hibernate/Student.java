/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xigma_hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
    
    @ManyToMany(mappedBy = "students")
    private Set<Class> classes = new HashSet<>();
    
    @OneToMany(mappedBy = "students")
    private Set<Score> scores = new HashSet<>();
    
    @OneToMany(mappedBy = "students")
    private List<Transcript> transcripts;

    public void printCourseScores(){
        for (Transcript transcript : transcripts ){
            Course course = transcript.getCourse();
            System.out.println(course.getCourseId()+" "+course.getName()+" "+ transcript.getScore());
        }
    }
    
    
    public Student(String username, String password, String studentId) {
        super(username, password);
        this.studentId = studentId;
    }

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
     * @return the transcripts
     */
    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    /**
     * @param transcripts the transcripts to set
     */
    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

   
    
}
