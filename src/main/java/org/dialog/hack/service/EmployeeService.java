/*
 * Copyright (c) 2010-2017 AdroitLogic Private Ltd. (https://www.adroitlogic.com). All Rights Reserved.
 *
 * AdroitLogic PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.dialog.hack.service;

import org.dialog.hack.model.Company;
import org.dialog.hack.model.EmployeeProfile;
import org.dialog.hack.model.EmployeeSupervisor;
import org.dialog.hack.model.User;
import org.dialog.hack.repository.EmployeeProfileRepository;
import org.dialog.hack.repository.UserRepository;
import org.dialog.hack.rest.resources.CompanyResource;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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

    //Return employee profile by his/her first name and last name
    public EmployeeProfileResource getEmployeeProfile(String firstName, String lastName) {
        try {
            //List<Employee_ProfileResource> employeeProfileResourceList = new ArrayList<Employee_ProfileResource>();
            EmployeeProfile employeeProfiles = employeeRepository.findByEmpFirstnameAndEmpLastname(firstName, lastName);
            EmployeeProfileResource employeeProfile = new EmployeeProfileResource(employeeProfiles);

            return employeeProfile;
            //return employeeProfiles.stream().map(EmployeeProfileResource::new).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    //Returns the all employee profile list
    public Page<EmployeeProfile> listEmployeeProfiles(int pageNo, int pageSize, String sortDir, String sortCol) {
        try {
            PageRequest pageRequest = new PageRequest(pageNo, pageSize, Sort.Direction.fromString(sortDir), sortCol);
            return employeeRepository.findAll(pageRequest);
        } catch (Exception e) {
            throw new IllegalArgumentException("Test");
        }
    }

    //Return employee profile list without paging
    public List<EmployeeProfileResource> getEmployeeProfileList() {
        try {
            List<EmployeeProfile> employeeProfiles = employeeRepository.findAll();

            return employeeProfiles.stream().map(EmployeeProfileResource::new).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

    //Delete employee by his staff number
    public boolean removeEmployeeProfileByStaffNo(String empStaffNo) {
        try {
            if (empStaffNo != null){
                Long deletedEmp = employeeRepository.deleteByEmpStaffNo(empStaffNo);
                if (deletedEmp != null){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    //Delete employee by his auto generated id in the entity
    public boolean removeEmployeeProfile(Long id) {
        try {
            if (id != null){
                employeeRepository.delete(id);
            }
            return false;
        }catch (Exception e){
            return false;
        }
    }

    //Create employee profile with user
    public boolean saveEmployeeProfile(EmployeeProfileResource employeeProfileResource){
        try {
            if (employeeProfileResource != null){
                    EmployeeProfile employeeProfile = employeeProfileResource.toEmployeeProfile();
                    if (employeeProfile.getUser() != null){
                        User user = userRepository.save(employeeProfile.getUser());
                        if (user != null){
                            employeeProfile = employeeRepository.save(employeeProfile);
                            if (employeeProfile != null){
                                return true;
                            }
                        }
                    }
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }


}
