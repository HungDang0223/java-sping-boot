package first_project.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import first_project.example.demo.models.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // Ví dụ về Custom Query (Tìm kiếm theo tên)
    List<Product> findByProductNameContainingIgnoreCase(String name);

    // Ví dụ về Custom Query (Tìm sản phẩm có giá mua lớn hơn)
    List<Product> findByBuyPriceGreaterThan(BigDecimal price);
}
