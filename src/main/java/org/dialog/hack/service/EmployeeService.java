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
 * Created by sasini on 5/27/17.
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

    public boolean removeEmployeeProfile(String empStaffNo) {
        try {
            if (empStaffNo != null){
                Long deletedEmp = employeeRepository.deleteByempStaffNo(empStaffNo);
                if (deletedEmp != null){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    public boolean saveEmployeeProfile(EmployeeProfileResource employeeProfileResource){
        try {
            User user = null;
            if (employeeProfileResource.getUser() != null) {
                user = employeeProfileResource.getUser().toUser();
                //employeeProfileResource.setUser(null);
                if (user != null) {
                    user = userRepository.save(user);
                }
                if (user != null) {
                    EmployeeProfile employeeProfile = employeeRepository.save(employeeProfileResource.toEmployeeProfile());
                    if (employeeProfile != null) {
                        return true;
                    }
                }
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }
}
