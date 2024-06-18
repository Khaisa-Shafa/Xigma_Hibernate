/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xigma_hibernate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "assignment")
public class Assignment extends Activity {

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ManyToMany
    @JoinTable(
        name = "assignment_student",   // Name of the join table
        joinColumns = @JoinColumn(name = "assignment_id"),  // FK column in this entity's table
        inverseJoinColumns = @JoinColumn(name = "student_id")  // FK column in the other entity's table
    )
    private Set<Student> assignees = new HashSet<>();


    @Override
    public String getDescription() {
        return "Assignment due on " + dueDate.toString();
    }
    //
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Set<Student> getAssignees() {
        return assignees;
    }

    public void setAssignees(Set<Student> assignees) {
        this.assignees = assignees;
    }
}

