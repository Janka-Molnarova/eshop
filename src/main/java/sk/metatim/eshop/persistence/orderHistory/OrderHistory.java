package sk.metatim.eshop.persistence.orderHistory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "order_history")
public class OrderHistory {

    @Id
    @GeneratedValue
    Long id;

    private String orderId;

    private OrderState orderState;

    private Timestamp date;
}
