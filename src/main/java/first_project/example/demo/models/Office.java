package first_project.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "offices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Office {

    @Id
    @Column(name = "officeCode", length = 10)
    private String officeCode;

    @Column(name = "city", length = 50, nullable = false)
    private String city;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "addressLine1", length = 50, nullable = false)
    private String addressLine1;

    @Column(name = "addressLine2", length = 50)
    private String addressLine2;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", length = 50, nullable = false)
    private String country;

    @Column(name = "postalCode", length = 15, nullable = false)
    private String postalCode;

    @Column(name = "territory", length = 10, nullable = false)
    private String territory;

    // Mối quan hệ 1-nhiều với Employees
    // @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    // private Set<Employee> employees;
}
