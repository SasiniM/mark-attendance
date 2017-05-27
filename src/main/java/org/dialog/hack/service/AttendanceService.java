package org.dialog.hack.service;

import org.dialog.hack.model.EmployeeAttendance;
import org.dialog.hack.repository.EmployeeAttendanceRepository;
import org.dialog.hack.rest.resources.EmployeeAttendanceResource;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by sasini on 5/27/17.
 */
public class AttendanceService {
    @Autowired
    EmployeeAttendanceRepository attendanceRepository;
    EmployeeAttendance employeeAttendance;

    public boolean saveEmployeeAttendance(EmployeeAttendanceResource employeeAttendanceResource){
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
}
