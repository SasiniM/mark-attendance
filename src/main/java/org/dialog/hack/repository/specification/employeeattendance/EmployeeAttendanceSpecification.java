/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package org.dialog.hack.repository.specification.employeeattendance;

import org.dialog.hack.model.EmployeeAttendance;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class EmployeeAttendanceSpecification implements Specification<EmployeeAttendance> {

    private final Date startDate;
    private final Date endDate;
    private final String firstName;
    private final String lastName;

    public EmployeeAttendanceSpecification(Date startDate, Date endDate, String firstName, String lastName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public Predicate toPredicate(Root<EmployeeAttendance> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        return cb.and(cb.between(root.get("attendanceDate"), startDate, endDate),
                cb.and(cb.equal(root.get("employeeProfile").get("empFirstname"), firstName),
                        cb.equal(root.get("employeeProfile").get("empLastname"), lastName)));
    }
}
