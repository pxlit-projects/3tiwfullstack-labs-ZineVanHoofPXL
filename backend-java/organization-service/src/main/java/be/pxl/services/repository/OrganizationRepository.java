package be.pxl.services.repository;

import be.pxl.services.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findOrganizationByIdAndDepartmentsIsNotNull(Long id);
    Optional<Organization> findOrganizationByIdAndDepartmentsIsNotNullAndEmployeesIsNotNull(Long id);
    Optional<Organization> findOrganizationByIdAndEmployeesIsNotNull(Long id);
}
