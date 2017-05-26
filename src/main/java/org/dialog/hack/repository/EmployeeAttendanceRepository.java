package org.dialog.hack.repository;

import org.dialog.hack.model.EmployeeAttendance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sasini on 5/24/17.
 */
public interface EmployeeAttendanceRepository extends CrudRepository<EmployeeAttendance, Integer> {

}
