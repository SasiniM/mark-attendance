package org.dialog.hack.repository;

import org.dialog.hack.model.EmployeeSupervisor;
import org.dialog.hack.rest.resources.EmployeeSupervisorResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sasini on 5/24/17.
 */
public interface EmployeeSupervisorRepository extends JpaRepository<EmployeeSupervisor, Long> {

    Long deleteBySupStaffNo(String supStaffNo);

    Page<EmployeeSupervisor> findAll(Pageable pageable);

    EmployeeSupervisor findOneByFirstnameAndLastname(String firstname, String lastname);
}
