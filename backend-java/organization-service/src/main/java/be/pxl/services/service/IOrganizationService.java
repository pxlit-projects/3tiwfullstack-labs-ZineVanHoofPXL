package be.pxl.services.service;

import be.pxl.services.domain.Organization;

public interface IOrganizationService {

    Organization getOrganization(Long id);
    Organization getOrganizationByIdWithDepartments(Long id);
    Organization getOrganizationByIdWithDepartmentsAndEmployees(Long id);
    Organization getOrganizationByIdWithEmployees(Long id);
}
