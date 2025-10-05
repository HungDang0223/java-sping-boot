package first_project.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import first_project.example.demo.models.Payment;
import first_project.example.demo.models.embedded_id.PaymentId;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {

    // Ví dụ về Custom Query (Tìm tất cả thanh toán của một khách hàng)
    // Chú ý: Spring Data JPA sẽ tự động tạo truy vấn này nếu bạn dùng PaymentId
    // List<Payment> findById_CustomerNumber(Integer customerNumber);
    List<Payment> findAll();
    Payment save(Payment payment);
}