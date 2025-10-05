package first_project.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    // Giả định đây là khóa tự tăng
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerNumber;

    private String customerName;

    private String contactLastName;

    private String contactFirstName;

    private String phone;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String postalCode;

    private String country;

    private BigDecimal creditLimit;

    // // Mối quan hệ nhiều-1 với Employee (Khóa ngoại salesRepEmployeeNumber)
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "salesRepEmployeeNumber")
    // private Employee salesRep;

    // // Mối quan hệ 1-nhiều với Payments
    // @ManyToOne(fetch = FetchType.LAZY)
    // @OneToMany(mappedBy = "customeNumber", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private Set<Payment> payments;

    // // Mối quan hệ 1-nhiều với Orders
    // @ManyToOne(fetch = FetchType.LAZY)
    // @OneToMany(mappedBy = "customerNumber", cascade = CascadeType.ALL)
    // private Set<Order> orders;
}
