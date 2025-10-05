package first_project.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import first_project.example.demo.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Ví dụ về Custom Query (Tìm kiếm khách hàng theo tên)
    List<Customer> findByCustomerNameContainingIgnoreCase(String name);

    // Ví dụ về Custom Query (Tìm khách hàng thuộc một quốc gia)
    List<Customer> findByCountry(String country);
}
