package first_project.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import first_project.example.demo.models.Office;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {

    // Ví dụ về Custom Query (Tìm văn phòng theo quốc gia)
    List<Office> findByCountry(String country);
}