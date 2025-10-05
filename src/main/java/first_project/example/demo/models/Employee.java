package first_project.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "employeeNumber")
    // Giả định đây là khóa tự tăng (auto-increment)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeNumber;

    @Column(name = "lastName", length = 50, nullable = false)
    private String lastName;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "extension", length = 10, nullable = false)
    private String extension;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "jobTitle", length = 50, nullable = false)
    private String jobTitle;

    // // Mối quan hệ nhiều-1 với Office (Khóa ngoại officeCode)
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "officeCode", nullable = false)
    // private Office office;

    // // Mối quan hệ tự tham chiếu (Self-referencing) - Người quản lý
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "reportsTo")
    // private Employee manager;

    // // Mối quan hệ tự tham chiếu - Các nhân viên cấp dưới
    // @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    // private Set<Employee> subordinates;

    // // Mối quan hệ 1-nhiều với Customers (Sales Rep)
    // @OneToMany(mappedBy = "salesRep", cascade = CascadeType.ALL)
    // private Set<Customer> customers;
}
