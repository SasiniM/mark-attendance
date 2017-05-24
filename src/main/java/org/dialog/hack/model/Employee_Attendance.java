package org.dialog.hack.model;

import javax.persistence.*;

/**
 * Created by sasini on 5/23/17.
 */
@Entity
public class Employee_Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer att_ID;
    private String attendance_date;
    private String attendance_intime;
    private String attendance_outtime;
    private Double worked_hours;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_ID", referencedColumnName = "emp_ID")
    Employee_Profile emp_profile;

    public Integer getAtt_ID() {
        return att_ID;
    }

    public void setAtt_ID(Integer att_ID) {
        this.att_ID = att_ID;
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

    public Double getWorked_hours() {
        return worked_hours;
    }

    public void setWorked_hours(Double worked_hours) {
        this.worked_hours = worked_hours;
    }

    public Employee_Profile getEmp_profile() {
        return emp_profile;
    }

    public void setEmp_profile(Employee_Profile emp_profile) {
        this.emp_profile = emp_profile;
    }
}
