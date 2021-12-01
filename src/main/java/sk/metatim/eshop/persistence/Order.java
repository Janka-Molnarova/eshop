package sk.metatim.eshop.persistence;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@ToString
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    Long id;

    boolean success;

    String message;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Convert(converter = OrderedItemsConverter.class)
    private Map<String, Integer> items;

    private Double price;
}
