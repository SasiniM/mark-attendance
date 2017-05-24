/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.service;

import org.dialog.hack.model.Employee_Profile;
import org.dialog.hack.repository.Employee_ProfileRepository;
import org.dialog.hack.rest.resources.Employee_ProfileResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class EmployeeService {

    @Autowired
    Employee_ProfileRepository employeeRepository;

    public List<Employee_ProfileResource> getemployeeProfiles(String firstName, String lastName) {
        //List<Employee_ProfileResource> employeeProfileResourceList = new ArrayList<Employee_ProfileResource>();
        List<Employee_Profile> employee_profiles =
                employeeRepository.findName(firstName, lastName);

        return employee_profiles.stream().map(Employee_ProfileResource::new).collect(Collectors.toList());
    }


}
