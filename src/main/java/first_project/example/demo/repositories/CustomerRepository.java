package first_project.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import first_project.example.demo.dto.CustomerGetOrdersResponseDto;
import first_project.example.demo.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Ví dụ về Custom Query (Tìm kiếm khách hàng theo tên)
    List<Customer> findByCustomerNameContainingIgnoreCase(String name);

    // Ví dụ về Custom Query (Tìm khách hàng thuộc một quốc gia)
    List<Customer> findByCountry(String country);

    @Query("SELECT DISTINCT c FROM Customer c " +
           "LEFT JOIN FETCH c.orders o " +
           "WHERE c.customerNumber = :cusNum")
    Optional<Customer> findByIdWithOrders(@Param("cusNum") Integer cusNum);

    @Query(value = "SELECT c.customer_number, c.customer_name, c.contact_last_name, " +
                   "c.contact_first_name, c.phone, " +
                   "o.order_number, o.order_date, o.required_date, " +
                   "o.shipped_date, o.status, o.comments " +
                   "FROM customers c " +
                   "LEFT JOIN orders o ON c.customer_number = o.customer_number " +
                   "WHERE c.customer_number = :cusNum",
           nativeQuery = true)
    List<CustomerGetOrdersResponseProjection> findByCustomerNumber(@Param("cusNum") Integer cusNum);
}
