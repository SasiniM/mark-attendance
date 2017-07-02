package org.dialog.hack.service;

import org.dialog.hack.model.EmployeeSupervisor;
import org.dialog.hack.model.User;
import org.dialog.hack.repository.EmployeeSupervisorRepository;
import org.dialog.hack.repository.UserRepository;
import org.dialog.hack.rest.resources.EmployeeSupervisorResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created by sasini on 5/27/17.
 */
public class SupervisorService {
    @Autowired
    EmployeeSupervisorRepository supervisorRepository;

    @Autowired
    UserRepository userRepository;

    public boolean saveEmployeeSupervisor(EmployeeSupervisorResource employeeSupervisorResource){
        try {
            if (employeeSupervisorResource != null) {
                EmployeeSupervisor employeeSupervisor = employeeSupervisorResource.toEmployeeSupervisor();
                if (employeeSupervisor.getUser1() != null) {
                    User user = userRepository.save(employeeSupervisor.getUser1());
                    if (user != null) {
                        employeeSupervisor = supervisorRepository.save(employeeSupervisor);
                        if (employeeSupervisor != null) {
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

    public boolean deleteEmployeeSupervisor(String supStaffNo){
        try {
            if (supStaffNo != null){
                Long deletedSup = supervisorRepository.deleteBysupStaffNo(supStaffNo);
                if (deletedSup != null){
                    return true;
                }
                else {
                    return false;
                }
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }

    public Page<EmployeeSupervisor> listEmployeeSupervisor(int pageNo, int pageSize, String sortDir, String sortCol) {
        try {
            PageRequest pageRequest = new PageRequest(pageNo, pageSize, Sort.Direction.fromString(sortDir), sortCol);
            return supervisorRepository.findAll(pageRequest);
        } catch (Exception e) {
            throw new IllegalArgumentException("Test");
        }
    }

}
