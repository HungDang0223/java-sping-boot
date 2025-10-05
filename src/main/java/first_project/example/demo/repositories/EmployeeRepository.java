package first_project.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import first_project.example.demo.models.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Ví dụ về Custom Query (Tìm nhân viên theo chức danh)
    List<Employee> findByJobTitle(String jobTitle);
}