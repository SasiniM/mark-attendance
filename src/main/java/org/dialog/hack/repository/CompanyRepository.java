package org.dialog.hack.repository;

import org.dialog.hack.model.Company;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author sasini.
 */
public interface CompanyRepository extends JpaRepository<Company, Long>{

    Long deleteByCompanyName(String companyName);

    List<EmployeeProfileResource> findAllById(Long id);

}
