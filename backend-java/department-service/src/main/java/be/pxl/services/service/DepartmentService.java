package be.pxl.services.service;

import be.pxl.services.domain.Department;
import be.pxl.services.exception.NotFoundException;
import be.pxl.services.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find department with id: " + id));
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<Department> getDepartmentsByOrganization(Long organizationId) {
        return departmentRepository.findAllByOrganizationId(organizationId);
    }

    public List<Department> getDepartmentsByOrganizationWithEmployees(Long organizationId) {
        return departmentRepository.findAllByOrganizationIdAndEmployeesIsNotNull(organizationId);
    }
}
