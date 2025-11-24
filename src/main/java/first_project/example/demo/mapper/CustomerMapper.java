package first_project.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import first_project.example.demo.dto.CustomerGetOrdersResponseDto;
import first_project.example.demo.dto.OrderResponseDto;
import first_project.example.demo.models.Customer;
import first_project.example.demo.models.Order;

@Component
public class CustomerMapper {
    
    public CustomerGetOrdersResponseDto toDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        
        List<OrderResponseDto> orderDtos = new ArrayList<>();
        if (customer.getOrders() != null) {
            orderDtos = customer.getOrders().stream()
                .map(this::toOrderDto)
                .collect(Collectors.toList());
        }
        
        CustomerGetOrdersResponseDto dto = new CustomerGetOrdersResponseDto();
        dto.setCustomerNumber(customer.getCustomerNumber());
        dto.setCustomerName(customer.getCustomerName());
        dto.setContactLastName(customer.getContactLastName());
        dto.setContactFirstName(customer.getContactFirstName());
        dto.setPhone(customer.getPhone());
        dto.setOrders(orderDtos);
        
        return dto;
    }
    
    public OrderResponseDto toOrderDto(Order order) {
        if (order == null) {
            return null;
        }
        
        OrderResponseDto dto = new OrderResponseDto();
        dto.setOrderNumber(order.getOrderNumber());
        dto.setOrderDate(order.getOrderDate());
        dto.setRequiredDate(order.getRequiredDate());
        dto.setShippedDate(order.getShippedDate());
        dto.setStatus(order.getStatus());
        dto.setComments(order.getComments());
        
        return dto;
    }
}
