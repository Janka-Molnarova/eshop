package sk.metatim.eshop.persistence.orderHistory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

    OrderHistory findByOrderId(String orderId);
}
