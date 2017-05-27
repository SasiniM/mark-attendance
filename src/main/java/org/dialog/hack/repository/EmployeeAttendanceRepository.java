package org.dialog.hack.repository;

import org.dialog.hack.model.EmployeeAttendance;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sasini on 5/24/17.
 */
public interface EmployeeAttendanceRepository extends CrudRepository<EmployeeAttendance, Integer> {

    List<EmployeeAttendance> findAll(Specification<EmployeeAttendance> specification);
}
