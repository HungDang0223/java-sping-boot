package first_project.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

import first_project.example.demo.models.embedded_id.PaymentId;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @EmbeddedId
    private PaymentId id;

    private LocalDate paymentDate;

    private BigDecimal amount;
}
