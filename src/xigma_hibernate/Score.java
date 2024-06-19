/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xigma_hibernate;

import javax.persistence.Column;
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
@Table(name="score")
public class Score{

    public Score(int score){
        this.score = score;
    }
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="score_value", nullable=false, unique = true)
    private int score;
    
    @ManyToOne
    @JoinColumn(name="class")
    private Class classes;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Student student;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Course course;
    
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
     * @return the classes
     */
    public Class getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(Class classes) {
        this.classes = classes;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

}
