package org.dialog.hack.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
public class Employee_Attendance {
    private String emp_ID;
    private String attendance_date;
    private String attendance_intime;
    private String attendance_outtime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_ID")
    Employee_Profile emp_profile;

    public String getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(String emp_ID) {
        this.emp_ID = emp_ID;
    }

    public String getAttendance_date() {
        return attendance_date;
    }

    public void setAttendance_date(String attendance_date) {
        this.attendance_date = attendance_date;
    }

    public String getAttendance_intime() {
        return attendance_intime;
    }

    public void setAttendance_intime(String attendance_intime) {
        this.attendance_intime = attendance_intime;
    }

    public String getAttendance_outtime() {
        return attendance_outtime;
    }

    public void setAttendance_outtime(String attendance_outtime) {
        this.attendance_outtime = attendance_outtime;
    }

    public Employee_Profile getEmp_profile() {
        return emp_profile;
    }

    public void setEmp_profile(Employee_Profile emp_profile) {
        this.emp_profile = emp_profile;
    }
}
