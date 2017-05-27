package org.dialog.hack.repository;

import org.dialog.hack.model.EmployeeProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sasini on 5/24/17.
 */
public interface EmployeeProfileRepository extends CrudRepository<EmployeeProfile, Long> {

    @Query("SELECT p FROM EmployeeProfile p WHERE p.empFirstname = ?1 AND p.empLastname = ?2")
    List<EmployeeProfile> findByEmpFirstnameAndEmpLastname(String empFirstname, String empLastname);
}

