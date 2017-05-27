package org.dialog.hack.service;

import org.dialog.hack.model.EmployeeProfile;
import org.dialog.hack.model.EmployeeSupervisor;
import org.dialog.hack.repository.EmployeeSupervisorRepository;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.dialog.hack.rest.resources.EmployeeSupervisorResource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sasini on 5/27/17.
 */
public class SupervisorService {
    @Autowired
    EmployeeSupervisorRepository supervisorRepository;

    public boolean saveEmployeeSupervisor(EmployeeSupervisorResource employeeSupervisorResource){
        EmployeeSupervisor employeeSupervisor;
        employeeSupervisor = supervisorRepository.save(employeeSupervisorResource.toEmployeeSupervisor());

        if (employeeSupervisor == null)
            return false;
        else
            return true;
    }
}
