package vn.edu.iuh.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.edu.iuh.models.Employee;

public interface EmployeeService {
    Page<Employee> findAll(Integer size, Integer page);
}
