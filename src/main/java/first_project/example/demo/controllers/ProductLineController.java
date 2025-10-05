package first_project.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import first_project.example.demo.models.ProductLine;
import first_project.example.demo.services.ProductLineService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productlines")
public class ProductLineController {

    private final ProductLineService productLineService;

    public ProductLineController(ProductLineService productLineService) {
        this.productLineService = productLineService;
    }

    // GET /api/v1/productlines
    @GetMapping
    public List<ProductLine> getAllProductLines() {
        return productLineService.getAllProductLines();
    }

    // GET /api/v1/productlines/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ProductLine> getProductLineById(@PathVariable String id) {
        return productLineService.getProductLineById(id)
                .map(ResponseEntity::ok) // Trả về 200 OK nếu tìm thấy
                .orElseGet(() -> ResponseEntity.notFound().build()); // Trả về 404 Not Found nếu không tìm thấy
    }

    // POST /api/v1/productlines
    @PostMapping
    public ResponseEntity<ProductLine> createProductLine(@RequestBody ProductLine productLine) {
        ProductLine savedLine = productLineService.saveProductLine(productLine);
        return new ResponseEntity<>(savedLine, HttpStatus.CREATED); // Trả về 201 CREATED
    }

    // PUT /api/v1/productlines/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ProductLine> updateProductLine(@PathVariable String id, @RequestBody ProductLine productLineDetails) {
        return productLineService.getProductLineById(id)
                .map(existingLine -> {
                    // Cập nhật các trường cần thiết
                    existingLine.setTextDescription(productLineDetails.getTextDescription());
                    existingLine.setHtmlDescription(productLineDetails.getHtmlDescription());
                    // ... (Thêm logic cho các trường khác)
                    
                    ProductLine updatedLine = productLineService.saveProductLine(existingLine);
                    return ResponseEntity.ok(updatedLine);
                })
                .orElseGet(() -> {
                    // Nếu không tìm thấy, có thể tạo mới (PUT-as-Create) hoặc trả về 404
                    productLineDetails.setProductLine(id);
                    ProductLine newLine = productLineService.saveProductLine(productLineDetails);
                    return new ResponseEntity<>(newLine, HttpStatus.CREATED);
                });
    }

    // DELETE /api/v1/productlines/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductLine(@PathVariable String id) {
        productLineService.deleteProductLine(id);
        return ResponseEntity.noContent().build(); // Trả về 204 No Content
    }
}
