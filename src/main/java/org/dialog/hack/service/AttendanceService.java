package org.dialog.hack.service;

import org.dialog.hack.model.EmployeeAttendance;
import org.dialog.hack.repository.EmployeeAttendanceRepository;
import org.dialog.hack.repository.specification.employeeattendance.EmployeeAttendanceSpecification;
import org.dialog.hack.rest.resources.EmployeeAttendanceResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.core.InteractionCallback;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by sasini on 5/27/17.
 */
public class AttendanceService {
    @Autowired
    EmployeeAttendanceRepository attendanceRepository;

    public boolean saveEmployeeAttendance(EmployeeAttendanceResource employeeAttendanceResource){
        EmployeeAttendance employeeAttendance = null;
        try {
            employeeAttendance = attendanceRepository.save(employeeAttendanceResource.toEmployeeAttendance());

        }catch (Exception e){
            e.printStackTrace();
        }
        if (employeeAttendance == null)
            return false;
        else
            return true;
    }


    public List<EmployeeAttendance> getEmployeeAttendances(String year, String month, String firstName, String lastName) {
        Date startDate = new Date();
        Date endDate = new Date();
        int mnth = 0;
        switch (month){
            case "January":mnth=1;
                break;
            case "February":mnth=2;
                break;
            case "March":mnth=3;
                break;
            case "April":mnth=4;
                break;
            case "May":mnth=5;
                break;
            case "June":mnth=6;
                break;
            case "July":mnth=7;
                break;
            case "August":mnth=8;
                break;
            case "September":mnth=9;
                break;
            case "October":mnth=10;
                break;
            case "November":mnth=11;
                break;
            case "December":mnth=12;
                break;
        }

        String startDateString = year+"-"+Integer.toString(mnth)+"-"+"01";
        String endDateString = year+"-"+Integer.toString(mnth+1)+"-"+"01";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            //startDate = DateFormat.getInstance().parse(startDateString);
            startDate = df.parse(startDateString);
            startDate = df.parse(endDateString);
            //endDate = DateFormat.getDateInstance().parse(endDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return attendanceRepository.findAll(new EmployeeAttendanceSpecification(startDate, endDate, firstName, lastName));

    }
}
