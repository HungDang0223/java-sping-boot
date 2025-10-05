package first_project.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "orderNumber")
    // Giả định đây là khóa tự tăng
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderNumber;

    @Column(name = "orderDate", nullable = false)
    private LocalDate orderDate;

    @Column(name = "requiredDate", nullable = false)
    private LocalDate requiredDate;

    @Column(name = "shippedDate")
    private LocalDate shippedDate;

    @Column(name = "status", length = 15, nullable = false)
    private String status;

    @Lob // Dùng cho kiểu TEXT
    @Column(name = "comments")
    private String comments;

    // Mối quan hệ nhiều-1 với Customer (Khóa ngoại customerNumber)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerNumber", nullable = false)
    private Customer customer;

    // Mối quan hệ 1-nhiều với OrderDetails
    // @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    // private Set<OrderDetail> orderDetails;
}
