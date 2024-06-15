/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xigma_hibernate;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Class classes;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Course course;
    
    @ManyToOne(fetch=FetchType.LAZY)
    private Student students;
    
//    @ManyToMany
//            @JoinTable(
//            name = "score_class",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name="score")
//            )
//    private Set<Student> students = new HashSet<>();
//    
//    @ManyToMany(mappedBy = "students")
//    private Set<Class> classes = new HashSet<>();


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

//    /**
//     * @return the classes
//     */
//    public Class getClasses() {
//        return classes;
//    }
//
//    /**
//     * @param classes the classes to set
//     */
//    public void setClasses(Class classes) {
//        this.setClasses(classes);
//    }

//    /**
//     * @return the students
//     */
//    public Set<Student> getStudents() {
//        return students;
//    }
//
//    /**
//     * @param students the students to set
//     */
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }

    /**
     * @return the students
     */
    public Student getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(Student students) {
        this.students = students;
    }

//    /**
//     * @param classes the classes to set
//     */
//    public void setClasses(Set<Class> classes) {
//        this.classes = classes;
//    }
//
//    /**
//     * @return the classes
//     */
//    public Set<Class> getClasses() {
//        return classes;
//    }

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

   
    
    
}
