package first_project.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import first_project.example.demo.models.Order;
import first_project.example.demo.repositories.OrderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    // Bạn sẽ cần inject OrderDetailRepository và ProductRepository nếu muốn xử lý logic phức tạp hơn

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // 1. Lấy tất cả
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // 2. Lấy theo ID
    public Optional<Order> getOrderById(Integer orderNumber) {
        return orderRepository.findById(orderNumber);
    }

    // 3. Tạo đơn hàng mới (Lưu ý: Logic này cần phức tạp hơn để xử lý OrderDetail và QuantityInStock)
    public Order createNewOrder(Order order) {
        // Logic nghiệp vụ:
        // 1. Đặt orderDate là ngày hiện tại
        order.setOrderDate(LocalDate.now());
        // 2. Thiết lập trạng thái ban đầu
        order.setStatus("In Process");
        
        // **Lưu ý quan trọng:** Trong thực tế, bạn sẽ cần lặp qua Set<OrderDetail>
        // để kiểm tra số lượng tồn kho (quantityInStock) trước khi lưu.
        
        return orderRepository.save(order);
    }
    
    // 4. Cập nhật trạng thái đơn hàng
    public Optional<Order> updateOrderStatus(Integer orderNumber, String newStatus) {
        return orderRepository.findById(orderNumber).map(order -> {
            // Logic nghiệp vụ: Kiểm tra tính hợp lệ của trạng thái mới
            if (isValidStatus(newStatus)) {
                order.setStatus(newStatus);
                if (newStatus.equalsIgnoreCase("Shipped")) {
                    order.setShippedDate(LocalDate.now());
                }
                return orderRepository.save(order);
            }
            throw new IllegalArgumentException("Invalid order status: " + newStatus);
        });
    }

    // Hàm kiểm tra trạng thái giả định
    private boolean isValidStatus(String status) {
        return List.of("In Process", "Shipped", "Resolved", "Cancelled").contains(status);
    }
}
