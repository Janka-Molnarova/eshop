package sk.metatim.eshop.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderId(String orderID);

    List<Order> findAllBySuccessIsFalse();

}
