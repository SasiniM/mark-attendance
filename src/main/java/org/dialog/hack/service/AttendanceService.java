package org.dialog.hack.service;

import org.dialog.hack.model.EmployeeAttendance;
import org.dialog.hack.repository.EmployeeAttendanceRepository;
import org.dialog.hack.repository.specification.employeeattendance.EmployeeAttendanceSpecification;
import org.dialog.hack.rest.resources.EmployeeAttendanceResource;
import org.springframework.beans.factory.annotation.Autowired;

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


        return attendanceRepository.findAll(new EmployeeAttendanceSpecification(startDate, endDate, firstName, lastName));

    }
}
