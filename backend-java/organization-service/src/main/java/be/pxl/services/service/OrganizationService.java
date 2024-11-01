package be.pxl.services.service;

import be.pxl.services.domain.Organization;
import be.pxl.services.exception.NotFoundException;
import be.pxl.services.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public Organization getOrganization(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find organization with id: " + id));
    }

    @Override
    public Organization getOrganizationByIdWithDepartments(Long id) {
        return organizationRepository.findOrganizationByIdAndDepartmentsIsNotNull(id)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    public Organization getOrganizationByIdWithDepartmentsAndEmployees(Long id) {
        return organizationRepository.findOrganizationByIdAndDepartmentsIsNotNullAndEmployeesIsNotNull(id)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    public Organization getOrganizationByIdWithEmployees(Long id) {
        return organizationRepository.findOrganizationByIdAndEmployeesIsNotNull(id)
                .orElseThrow(() -> new NotFoundException(""));
    }
}
