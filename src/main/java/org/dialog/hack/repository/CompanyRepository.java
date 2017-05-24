package org.dialog.hack.repository;

import org.dialog.hack.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author sasini.
 */
public interface CompanyRepository extends CrudRepository <Company, Integer> {

//    @Query("SELECT t.getCompany_name FROM Company t where t.company_ID = :id")
//    String findComapanyNameById(@Param("id") Integer id);

}
