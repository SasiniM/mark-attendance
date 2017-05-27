/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.service;

import org.dialog.hack.model.EmployeeProfile;
import org.dialog.hack.model.User;
import org.dialog.hack.repository.EmployeeProfileRepository;
import org.dialog.hack.repository.UserRepository;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Amila Karunathilaka
 * @since 17.07
 */
public class EmployeeService {

    @Autowired
    EmployeeProfileRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    public List<EmployeeProfileResource> getEmployeeProfiles(String firstName, String lastName) {
        try {
            //List<Employee_ProfileResource> employeeProfileResourceList = new ArrayList<Employee_ProfileResource>();
            List<EmployeeProfile> employeeProfiles = employeeRepository.findByEmpFirstnameAndEmpLastname(firstName, lastName);

            return employeeProfiles.stream().map(EmployeeProfileResource::new).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    public boolean saveEmployeeProfile(EmployeeProfileResource employeeProfileResource){
        try {
            User user = null;
            if (employeeProfileResource.getUser() != null) {
                user= employeeProfileResource.getUser().toUser();
                employeeProfileResource.setUser(null);
            }
            EmployeeProfile employeeProfile = employeeRepository.save(employeeProfileResource.toEmployeeProfile());
            if (user != null) {
                user.setEmployeeProfile(employeeProfile);
                user = userRepository.save(user);
            }

            if (employeeProfile == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
