package first_project.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import first_project.example.demo.models.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Ví dụ về Custom Query (Tìm đơn hàng theo trạng thái)
    List<Order> findByStatus(String status);

    // Ví dụ về Custom Query (Tìm đơn hàng của một khách hàng cụ thể)
    // List<Order> findByCustomer_CustomerNumber(Integer customerNumber);
}
