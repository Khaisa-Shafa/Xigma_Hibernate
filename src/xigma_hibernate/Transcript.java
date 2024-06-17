/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xigma_hibernate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author VIVOBOOK
 */
@Entity
@Table(name="transcript")
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Course courseCode;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Course name;
    
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private int score;

    public Transcript(Course courseCode, Course name,int score) {
        this.courseCode = courseCode;
        this.name = name;
        this.score = score;
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

   
    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

   
    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the courseCode
     */
    public Course getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(Course courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return the name
     */
    public Course getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Course name) {
        this.name = name;
    }

    

   

  
    
    
}
