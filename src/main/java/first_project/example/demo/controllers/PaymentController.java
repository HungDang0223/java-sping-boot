package first_project.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import first_project.example.demo.models.Payment;
import first_project.example.demo.services.PaymentService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // GET /api/v1/payments
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    // GET /api/v1/payments/{customerNumber}/{checkNumber}
    @GetMapping("/{customerNumber}/{checkNumber}")
    public ResponseEntity<Payment> getPaymentById(
            @PathVariable Integer customerNumber,
            @PathVariable String checkNumber) {
        
        return paymentService.getPaymentById(customerNumber, checkNumber)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/v1/payments
    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        try {
            Payment newPayment = paymentService.processPayment(payment);
            return new ResponseEntity<>(newPayment, HttpStatus.CREATED); // 201 Created
        } catch (IllegalArgumentException e) {
            // Xử lý lỗi nghiệp vụ từ Service
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
    }
    
    // DELETE /api/v1/payments/{customerNumber}/{checkNumber}
    @DeleteMapping("/{customerNumber}/{checkNumber}")
    public ResponseEntity<Void> deletePayment(
            @PathVariable Integer customerNumber,
            @PathVariable String checkNumber) {
        
        paymentService.deletePayment(customerNumber, checkNumber);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
  
}
