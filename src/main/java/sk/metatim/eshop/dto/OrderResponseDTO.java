package sk.metatim.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDTO {

    boolean success;
    String message;
    double price;
    String orderID;

    public OrderResponseDTO() {

    }
}
