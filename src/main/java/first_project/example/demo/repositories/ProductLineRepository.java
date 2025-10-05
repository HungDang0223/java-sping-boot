package first_project.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import first_project.example.demo.models.ProductLine;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine, String> {
    // JpaRepository<[Tên Entity], [Kiểu dữ liệu của Primary Key]>

    // Ví dụ về Custom Query (Tự định nghĩa)
    // List<ProductLine> findByTextDescriptionContaining(String keyword);
}
