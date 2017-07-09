package org.dialog.hack.repository;

import org.dialog.hack.model.EmployeeProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sasini on 5/24/17.
 */
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {

    @Query("SELECT p FROM EmployeeProfile p WHERE p.empFirstname = ?1 AND p.empLastname = ?2")
    List<EmployeeProfile> findProfile(String fname, String lname);

    EmployeeProfile findByEmpFirstnameAndEmpLastname(String empFirstname, String empLastname);

    Long deleteByEmpStaffNo(String empStaffNo);

    Page<EmployeeProfile> findAll(Pageable pageable);


}

