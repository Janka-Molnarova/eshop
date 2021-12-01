package sk.metatim.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import sk.metatim.eshop.helper.OrderResponseMessage;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDTO {

    boolean success;
    OrderResponseMessage message;
    double price;
    String orderID;

    public OrderResponseDTO() {

    }
}
