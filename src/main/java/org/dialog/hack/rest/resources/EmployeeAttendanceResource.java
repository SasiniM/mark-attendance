package org.dialog.hack.rest.resources;

import org.dialog.hack.model.EmployeeAttendance;

import javax.persistence.Column;
import java.sql.Time;
import java.util.Date;

/**
 * Created by sasini on 5/24/17.
 */
public class EmployeeAttendanceResource {
    private Long id;
    private Date attendanceDate;
    private Time attendanceIntime;
    private Time attendanceOuttime;
    private Double workedHours;

    private EmployeeProfileResource employeeProfileResource;

    public EmployeeAttendanceResource(EmployeeAttendance employeeAttendance){
        this.id = employeeAttendance.getId();
        this.attendanceDate = employeeAttendance.getAttendanceDate();
        this.attendanceIntime= employeeAttendance.getAttendanceIntime();
        this.attendanceOuttime = employeeAttendance.getAttendanceOuttime();
        this.workedHours = employeeAttendance.getWorkedHours();
        this.employeeProfileResource = new EmployeeProfileResource(employeeAttendance.getEmployeeProfile());
    }

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

    public EmployeeProfileResource getEmployeeProfileResource() {
        return employeeProfileResource;
    }

    public void setEmployeeProfileResource(EmployeeProfileResource employeeProfileResource) {
        this.employeeProfileResource = employeeProfileResource;
    }
}
