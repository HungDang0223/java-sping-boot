package first_project.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import first_project.example.demo.dto.OrderResponseDto;
import lombok.Data;

public interface CustomerGetOrdersResponseProjection {
    Integer getCustomerNumber();
    String getCustomerName();
    String getContactLastName();
    String getContactFirstName();
    String getPhone();
    List<OrderResponseDto> getOrders();
}
