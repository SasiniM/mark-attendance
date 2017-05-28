/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.repository.specification.employeeattendance;

import org.dialog.hack.model.EmployeeAttendance;
import org.dialog.hack.model.EmployeeProfile;
import org.dialog.hack.model.User;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class EmployeeAttendanceMarkSpecification implements Specification<EmployeeAttendance> {

    private final String username;
    private final Date date;

    public EmployeeAttendanceMarkSpecification(String username, Date date) {
        this.username = username;
        this.date = date;
    }

    @Override
    public Predicate toPredicate(Root<EmployeeAttendance> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        return cb.and(
                cb.equal(root.<Date>get("attendanceDate"), date),
                cb.equal(root.<EmployeeProfile>get("employeeProfile").<User>get("user").get("username"), username));
    }
}
