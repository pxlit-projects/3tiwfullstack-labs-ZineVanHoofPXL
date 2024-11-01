package be.pxl.services.controller;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.service.DepartmentService;
import be.pxl.services.service.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;
    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public ResponseEntity<Void> addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        logger.info(String.format("Added new department: %s", department.getName()));
        return ResponseEntity.created(URI.create("/api/department")).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        Department department = departmentService.getDepartment(id);
        logger.info(String.format("Fetched department: %s", department.getName()));
        return ResponseEntity.ok(department);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        logger.info("Fetched all departments");
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<Department>> getDepartmentsByOrganizationId(@PathVariable Long organizationId) {
        logger.info(String.format("Fetched all departments with organization id: %d", organizationId));
        return ResponseEntity.ok(departmentService.getDepartmentsByOrganization(organizationId));
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<List<Department>> getDepartmentsByOrganizationIdWithEmployees(@PathVariable Long organizationId) {
        logger.info(String.format("Fetched all departments with organization id: %d and with employees", organizationId));
        return ResponseEntity.ok(departmentService.getDepartmentsByOrganizationWithEmployees(organizationId));
    }
}
