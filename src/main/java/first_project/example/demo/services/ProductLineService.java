package first_project.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first_project.example.demo.models.ProductLine;
import first_project.example.demo.repositories.ProductLineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductLineService {

    private final ProductLineRepository productLineRepository;

    @Autowired
    public ProductLineService(ProductLineRepository productLineRepository) {
        this.productLineRepository = productLineRepository;
    }

    // 1. Lấy tất cả
    public List<ProductLine> getAllProductLines() {
        return productLineRepository.findAll();
    }

    // 2. Lấy theo ID
    public Optional<ProductLine> getProductLineById(String productLineId) {
        return productLineRepository.findById(productLineId);
    }

    // 3. Thêm/Cập nhật (SAVE)
    public ProductLine saveProductLine(ProductLine productLine) {
        // Có thể thêm logic kiểm tra trùng lặp hoặc chuẩn hóa dữ liệu tại đây
        return productLineRepository.save(productLine);
    }

    // 4. Xóa
    public void deleteProductLine(String productLineId) {
        productLineRepository.deleteById(productLineId);
    }
}
