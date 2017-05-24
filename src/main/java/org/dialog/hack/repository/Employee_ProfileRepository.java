package org.dialog.hack.repository;

import org.dialog.hack.model.Employee_Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sasini on 5/24/17.
 */
public interface Employee_ProfileRepository extends CrudRepository<Employee_Profile, Integer> {

    @Query("select emp from Employee_Profile emp where emp_firstname = ?1 and emp_lastname = ?2")
    List<Employee_Profile> findName(String emp_firstname, String emp_lastname);
}
