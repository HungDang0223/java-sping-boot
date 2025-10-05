package first_project.example.demo.repositories;


import first_project.example.demo.models.OrderDetail;
import first_project.example.demo.models.embedded_id.OrderDetailId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

    // Ví dụ về Custom Query (Tìm tất cả chi tiết đơn hàng của một mã sản phẩm)
    List<OrderDetail> findById_ProductCode(String productCode);
}