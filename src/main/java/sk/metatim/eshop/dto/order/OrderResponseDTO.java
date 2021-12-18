package sk.metatim.eshop.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sk.metatim.eshop.helper.OrderResponseMessage;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderResponseDTO {

    String orderID;
    boolean success;
    OrderResponseMessage message;
    double price;

    public OrderResponseDTO() {

    }
}
