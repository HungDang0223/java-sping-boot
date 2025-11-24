package first_project.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "productlines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductLine {

    @Id
    @Column(name = "productLine", length = 50)
    private String productLine;

    @Column(name = "textDescription", length = 4000)
    private String textDescription;

    @Lob // Dùng cho kiểu MEDIUMTEXT
    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Lob // Dùng cho kiểu MEDIUMBLOB
    @Column(name = "image")
    private byte[] image;

    // Mối quan hệ 1-nhiều với Products
    // @OneToMany(mappedBy = "productLine", cascade = CascadeType.ALL)
    // private Set<Product> products;
}