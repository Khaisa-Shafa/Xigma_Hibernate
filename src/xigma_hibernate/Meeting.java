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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "meeting")
public class Meeting extends Activity {

    @Column(name = "meeting_start_time")
    private LocalDateTime meetingStartTime;

    @ManyToMany(mappedBy = "meetings")
    private Set<Student> attendees = new HashSet<>();

    @Override
    public String getDescription() {
        return "Meeting at " + meetingStartTime.toString();
    }
    //
    public LocalDateTime getMeetingStartTime() {
        return meetingStartTime;
    }

    public void setMeetingStartTime(LocalDateTime meetingStartTime) {
        this.meetingStartTime = meetingStartTime;
    }

    public Set<Student> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<Student> attendees) {
        this.attendees = attendees;
    }
}
