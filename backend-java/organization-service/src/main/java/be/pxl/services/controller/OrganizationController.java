package be.pxl.services.controller;

import be.pxl.services.domain.Organization;
import be.pxl.services.service.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final IOrganizationService organizationService;

    @GetMapping("/{id}")
    public ResponseEntity<Organization> getOrganization(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganization(id));
    }

    @GetMapping("/{id}/with-departments")
    public ResponseEntity<Organization> getOrganizationByIdWithDepartments(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationByIdWithDepartments(id));
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity<Organization> getOrganizationByIdWithDepartmentsAndEmployees(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationByIdWithDepartmentsAndEmployees(id));
    }

    @GetMapping("/{id}/with-employees")
    public ResponseEntity<Organization> getOrganizationByIdWithEmployees(@PathVariable Long id) {
        return ResponseEntity.ok(organizationService.getOrganizationByIdWithEmployees(id));
    }
}
