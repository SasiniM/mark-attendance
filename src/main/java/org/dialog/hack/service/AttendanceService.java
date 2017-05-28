package org.dialog.hack.service;

import org.dialog.hack.model.EmployeeAttendance;
import org.dialog.hack.model.User;
import org.dialog.hack.repository.EmployeeAttendanceRepository;
import org.dialog.hack.repository.UserRepository;
import org.dialog.hack.repository.specification.employeeattendance.EmployeeAttendanceGetSpecification;
import org.dialog.hack.repository.specification.employeeattendance.EmployeeAttendanceMarkSpecification;
import org.dialog.hack.rest.resources.EmployeeAttendanceResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by sasini on 5/27/17.
 */
public class AttendanceService {
    @Autowired
    EmployeeAttendanceRepository attendanceRepository;

    @Autowired
    UserRepository userRepository;

    public boolean saveEmployeeAttendance(String username){
        EmployeeAttendance employeeAttendance = null;
        try {
            Date date = new Date(System.currentTimeMillis());
            employeeAttendance = attendanceRepository.findOne(new EmployeeAttendanceMarkSpecification(username, date));
            if (employeeAttendance == null) {
                User user = userRepository.findByUsername(username);
                employeeAttendance = new EmployeeAttendance();
                employeeAttendance.setAttendanceDate(new Date(Calendar.getInstance().getTimeInMillis()));
                employeeAttendance.setAttendanceIntime(new Time(employeeAttendance.getAttendanceDate().getTime()));
                employeeAttendance.setEmployeeProfile(user.getEmployeeProfile());
            } else if (employeeAttendance.getAttendanceOuttime() == null) {
                employeeAttendance.setAttendanceOuttime(new Time(System.currentTimeMillis()));
                Double workHours = (employeeAttendance.getAttendanceOuttime().toLocalTime().getLong(ChronoField.MINUTE_OF_DAY) -
                        employeeAttendance.getAttendanceIntime().toLocalTime().getLong(ChronoField.MINUTE_OF_DAY)) / 60.0;

                employeeAttendance.setWorkedHours(workHours);
            } else {

            }
            employeeAttendance = attendanceRepository.save(employeeAttendance);

        }catch (Exception e){
            e.printStackTrace();
        }
        if (employeeAttendance == null)
            return false;
        else
            return true;
    }

    public List<EmployeeAttendanceResource> getEmployeeAttendances(String year, String month, String firstName, String lastName) {
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
            Date startDate = new Date(df.parse(startDateString).getTime());
            Date endDate = new Date(df.parse(endDateString).getTime());
            //endDate = DateFormat.getDateInstance().parse(endDateString);
            List<EmployeeAttendance> attendances =
                    attendanceRepository.findAll(new EmployeeAttendanceGetSpecification(startDate, endDate, firstName, lastName));
            return attendances.stream().map(EmployeeAttendanceResource::new).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }


    }
}
