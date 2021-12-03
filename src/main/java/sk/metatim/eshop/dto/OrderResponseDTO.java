package sk.metatim.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sk.metatim.eshop.helper.OrderResponseMessage;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDTO {

    String orderID;
    boolean success;
    OrderResponseMessage message;
    double price;

    public OrderResponseDTO() {

    }
}
