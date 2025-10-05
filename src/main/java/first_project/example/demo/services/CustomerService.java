package first_project.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first_project.example.demo.models.Customer;
import first_project.example.demo.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 1. Lấy tất cả
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 2. Lấy theo ID
    public Optional<Customer> getCustomerById(Integer customerNumber) {
        return customerRepository.findById(customerNumber);
    }

    // 3. Thêm/Cập nhật
    public Customer saveCustomer(Customer customer) {
        // Logic nghiệp vụ: Ví dụ: Không cho phép creditLimit vượt quá 200,000
        /*
        if (customer.getCreditLimit() != null && customer.getCreditLimit().compareTo(new BigDecimal("200000")) > 0) {
             throw new IllegalArgumentException("Credit limit cannot exceed 200,000");
        }
        */
        return customerRepository.save(customer);
    }

    // 4. Xóa
    public void deleteCustomer(Integer customerNumber) {
        customerRepository.deleteById(customerNumber);
    }
    
    // 5. Tìm khách hàng theo quốc gia
    public List<Customer> getCustomersByCountry(String country) {
        return customerRepository.findByCountry(country);
    }
}
