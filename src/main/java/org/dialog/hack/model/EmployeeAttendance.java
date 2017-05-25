package org.dialog.hack.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
public class EmployeeAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "attendance_Date")
    private Date attendanceDate;
    @Column(name = "attendance_intime")
    private Time attendanceIntime;
    @Column(name = "outtime")
    private Time attendanceOuttime;
    @Column(name = "worked_hours")
    private Double workedHours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeProfile_id", referencedColumnName = "id")
    EmployeeProfile employeeProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Time getAttendanceIntime() {
        return attendanceIntime;
    }

    public void setAttendanceIntime(Time attendanceIntime) {
        this.attendanceIntime = attendanceIntime;
    }

    public Time getAttendanceOuttime() {
        return attendanceOuttime;
    }

    public void setAttendanceOuttime(Time attendanceOuttime) {
        this.attendanceOuttime = attendanceOuttime;
    }

    public Double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Double workedHours) {
        this.workedHours = workedHours;
    }

    public EmployeeProfile getEmployeeProfile() {
        return employeeProfile;
    }

    public void setEmployeeProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
    }
}
