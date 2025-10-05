package first_project.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first_project.example.demo.models.Product;
import first_project.example.demo.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. Lấy tất cả
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Lấy theo Code
    public Optional<Product> getProductByCode(String productCode) {
        return productRepository.findById(productCode);
    }

    // 3. Thêm/Cập nhật
    public Product saveProduct(Product product) {
        // Logic nghiệp vụ: Ví dụ: Tự động tính giá MSRP dựa trên buyPrice
        // product.setMsrp(product.getBuyPrice().multiply(new BigDecimal("1.3"))); 
        
        return productRepository.save(product);
    }

    // 4. Xóa
    public void deleteProduct(String productCode) {
        productRepository.deleteById(productCode);
    }
    
    // 5. Tìm theo tên
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }
}
