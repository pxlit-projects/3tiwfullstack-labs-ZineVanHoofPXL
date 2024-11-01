package be.pxl.services.service;

import be.pxl.services.domain.Department;

import java.util.List;

public interface IDepartmentService {

    void addDepartment(Department department);
    Department getDepartment(Long id);
    List<Department> getAllDepartments();
    List<Department> getDepartmentsByOrganization(Long organizationId);
    List<Department> getDepartmentsByOrganizationWithEmployees(Long organizationId);
}
