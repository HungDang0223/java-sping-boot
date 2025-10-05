package first_project.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "productCode", length = 15)
    private String productCode;

    @Column(name = "productName", length = 70, nullable = false)
    private String productName;

    @Column(name = "productScale", length = 10, nullable = false)
    private String productScale;

    @Column(name = "productVendor", length = 50, nullable = false)
    private String productVendor;

    @Lob // Dùng cho kiểu TEXT
    @Column(name = "productDescription", nullable = false)
    private String productDescription;

    @Column(name = "quantityInStock", nullable = false)
    private Short quantityInStock; // smallint(6)

    @Column(name = "buyPrice", precision = 10, scale = 2, nullable = false)
    private BigDecimal buyPrice;

    @Column(name = "MSRP", precision = 10, scale = 2, nullable = false)
    private BigDecimal msrp;

    // Mối quan hệ nhiều-1 với ProductLine (Khóa ngoại productLine)
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "productLine", nullable = false)
    // private ProductLine productLine;

    // // Mối quan hệ 1-nhiều với OrderDetail
    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    // private Set<OrderDetail> orderDetails;
}
