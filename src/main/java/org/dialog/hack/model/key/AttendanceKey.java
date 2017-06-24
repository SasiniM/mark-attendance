/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.model.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
@Embeddable
public class AttendanceKey {
    @Column(name = "Attendance_Date", nullable = false)
    private Date attendanceDate;

    @Column(name = "Emp_Profile_ID", nullable = false)
    private Long empId;

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Long getEmp_Id() {
        return empId;
    }

    public void setEmp_Id(Long empId) {
        this.empId = empId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttendanceKey that = (AttendanceKey) o;

        if (attendanceDate != null ? !attendanceDate.equals(that.attendanceDate) : that.attendanceDate != null)
            return false;
        return empId != null ? empId.equals(that.empId) : that.empId == null;
    }

    @Override
    public int hashCode() {
        int result = attendanceDate != null ? attendanceDate.hashCode() : 0;
        result = 31 * result + (empId != null ? empId.hashCode() : 0);
        return result;
    }
}
