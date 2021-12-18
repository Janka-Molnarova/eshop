package sk.metatim.eshop.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sk.metatim.eshop.helper.OrderResponseMessage;

import java.util.Map;

@Getter
@Setter
@ToString
public class GetOrderResponseDTO {

    private String id;

    private boolean success;

    private OrderResponseMessage message;

    private String orderId;

    private String customerId;

    private Map<String, Integer> items;

    private Double price;

}
