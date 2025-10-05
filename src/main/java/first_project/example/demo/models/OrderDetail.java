package first_project.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;

import first_project.example.demo.models.embedded_id.OrderDetailId;

@Entity
@Table(name = "orderdetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;

    @Column(name = "quantityOrdered", nullable = false)
    private Integer quantityOrdered;

    @Column(name = "priceEach", precision = 10, scale = 2, nullable = false)
    private BigDecimal priceEach;

    @Column(name = "orderLineNumber", nullable = false)
    private Short orderLineNumber; // smallint(6)
}
