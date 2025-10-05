package first_project.example.demo.models.embedded_id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentId implements Serializable {

    private Integer customerNumber;

    private String checkNumber;
}
