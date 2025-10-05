package first_project.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first_project.example.demo.models.Payment;
import first_project.example.demo.models.embedded_id.PaymentId;
import first_project.example.demo.repositories.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // 1. Lấy tất cả thanh toán
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // 2. Lấy thanh toán theo ID kép (CustomerNumber và CheckNumber)
    public Optional<Payment> getPaymentById(Integer customerNumber, String checkNumber) {
        PaymentId id = new PaymentId(customerNumber, checkNumber);
        return paymentRepository.findById(id);
    }

    // 3. Thực hiện thanh toán mới (Tạo/Cập nhật)
    public Payment processPayment(Payment payment) {
        // Logic nghiệp vụ:
        // 1. Đảm bảo paymentDate được thiết lập là ngày hiện tại nếu chưa có
        if (payment.getPaymentDate() == null) {
            payment.setPaymentDate(LocalDate.now());
        }
        
        // 2. Kiểm tra amount: Đảm bảo số tiền thanh toán là hợp lệ (> 0)
        if (payment.getAmount() == null || payment.getAmount().signum() <= 0) {
             throw new IllegalArgumentException("Payment amount must be positive.");
        }
        
        // **Lưu ý quan trọng:** Trong thực tế, service này còn cần phải:
        // - Kiểm tra tính hợp lệ của customerNumber (khách hàng có tồn tại không).
        // - Cập nhật trạng thái Order (nếu thanh toán gắn với Order cụ thể).
        
        return paymentRepository.save(payment);
    }

    // 4. Xóa thanh toán
    public void deletePayment(Integer customerNumber, String checkNumber) {
        PaymentId id = new PaymentId(customerNumber, checkNumber);
        paymentRepository.deleteById(id);
    }
}
