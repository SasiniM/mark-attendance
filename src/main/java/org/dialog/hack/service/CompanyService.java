package org.dialog.hack.service;

import org.dialog.hack.model.Company;
import org.dialog.hack.repository.CompanyRepository;
import org.dialog.hack.rest.resources.CompanyResource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sasini on 5/24/17.
 */
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public boolean saveCompany(CompanyResource companyResource){
        try {
            if (companyResource != null) {
                Company company = companyResource.toCompany();


                    if (company != null) {
                        company = companyRepository.save(company);
                        if (company != null) {
                            return true;
                        }
                    }

            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
