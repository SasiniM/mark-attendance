package org.dialog.hack.service;

import org.dialog.hack.model.Company;
import org.dialog.hack.repository.CompanyRepository;
import org.dialog.hack.repository.EmployeeProfileRepository;
import org.dialog.hack.rest.resources.CompanyResource;
import org.dialog.hack.rest.resources.EmployeeProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sasini on 5/24/17.
 */
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    //Create company
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

    //Delete company by its name
    public boolean deleteCompanyByName(String companyName){
        try {
            if (companyName != null){
                Long deletedCom = companyRepository.deleteByCompanyName(companyName);
                if (deletedCom != null){
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

    //Delete the company from the auto generated id
    public boolean deleteCompany(Long id){
        try {
            if (id != null){
                companyRepository.delete(id);
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    //Return the company list without paging
    public List<CompanyResource> getCompanies() {
        try {
            List<Company> companies = companyRepository.findAll();
            return companies.stream().map(CompanyResource::new).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();

            return  null;
        }
    }

    //Return the company list with paging
    public Page<Company> listCompanies(int pageNo, int pageSize, String sortDir, String sortCol) {
        try {
            PageRequest pageRequest = new PageRequest(pageNo, pageSize, Sort.Direction.fromString(sortDir), sortCol);
            return companyRepository.findAll(pageRequest);
        } catch (Exception e) {
            throw new IllegalArgumentException("Test");
        }
    }

    public List<EmployeeProfileResource> listEmployeeByCompany(Long id){
        try {
            List<EmployeeProfileResource> employeeProfileResources = companyRepository.findAllById(id);
            return employeeProfileResources;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
