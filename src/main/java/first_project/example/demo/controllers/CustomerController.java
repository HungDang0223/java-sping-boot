package first_project.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import first_project.example.demo.dto.CustomerGetOrdersResponseDto;
import first_project.example.demo.models.Customer;
import first_project.example.demo.services.CustomerService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
  private final CustomerService customerService;
  public CustomerController(CustomerService service) {
      customerService = service;
  }
  @PostMapping("")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
      try {
        Customer savedCustomer = this.customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body(savedCustomer);
      } catch (Exception ex) {
        throw new RuntimeException();
      }
  }
  @GetMapping("/{customer_number}/orders")
  public ResponseEntity<CustomerGetOrdersResponseDto> getCustomerWithOrders(@RequestParam("customer_number") Integer customer_number) {
    try {
      CustomerGetOrdersResponseDto orders = this.customerService.getCustomerWithOrders(customer_number);
      return ResponseEntity.status(HttpStatus.OK).body(orders);
    } catch (Exception ex) {
      throw new RuntimeException();
    }
  }
  
}
