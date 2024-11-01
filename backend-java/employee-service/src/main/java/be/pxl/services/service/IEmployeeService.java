package be.pxl.services.service;

import be.pxl.services.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    void addEmployee(Employee employee);
    Employee getEmployee(Long id);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByDepartment(Long departmentId);
    List<Employee> getEmployeesByOrganization(Long organizationId);
}
