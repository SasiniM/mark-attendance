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

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sasini on 5/27/17.
 */
public class SupervisorService {
    @Autowired
    EmployeeSupervisorRepository supervisorRepository;

    @Autowired
    UserRepository userRepository;

    //Create employee supervisor
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

    //Delete the employee supervisor by his/her staff number
    public boolean deleteEmployeeSupervisorByStaffno(String supStaffNo){
        try {
            if (supStaffNo != null){
                Long deletedSup = supervisorRepository.deleteBySupStaffNo(supStaffNo);
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

    //Delete the supervisor by his/her id(auto generating id)
    public boolean deleteEmployeeSupervisor(Long id){
        try {
            if (id != null){
                supervisorRepository.delete(id);
                    return true;
            }
            return false;

        } catch (Exception e) {
            return false;
        }
    }

    //Returns the all employee supervisor list
    public Page<EmployeeSupervisor> listEmployeeSupervisor(int pageNo, int pageSize, String sortDir, String sortCol) {
        try {
            PageRequest pageRequest = new PageRequest(pageNo, pageSize, Sort.Direction.fromString(sortDir), sortCol);
            return supervisorRepository.findAll(pageRequest);
        } catch (Exception e) {
            throw new IllegalArgumentException("Test");
        }
    }

    //Returns the details of the named supervisor
    public EmployeeSupervisorResource getSupervisorProfile(String firstName, String lastName) {
        try {
            EmployeeSupervisor employeeSupervisor = supervisorRepository.findOneByFirstnameAndLastname(firstName, lastName);
            EmployeeSupervisorResource employeeSupervisorResource = new EmployeeSupervisorResource(employeeSupervisor);

            return employeeSupervisorResource;

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //Return employee supervisor profile list without paging
    public List<EmployeeSupervisorResource> getSupervisorProfileList() {
        try {
            List<EmployeeSupervisor> employeeSupervisors = supervisorRepository.findAll();

            return employeeSupervisors.stream().map(EmployeeSupervisorResource::new).collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
    }

}
