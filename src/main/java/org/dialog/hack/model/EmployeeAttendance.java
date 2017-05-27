package org.dialog.hack.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
@Table(name = "Employee_Attendance")
public class EmployeeAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Attendance_Date")
    private Date attendanceDate;
    @Column(name = "Attendance_Intime")
    private Time attendanceIntime;
    @Column(name = "Attendance_Outtime")
    private Time attendanceOuttime;
    @Column(name = "Worked_Hours")
    private Double workedHours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Emp_Profile_ID", referencedColumnName = "ID")
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
