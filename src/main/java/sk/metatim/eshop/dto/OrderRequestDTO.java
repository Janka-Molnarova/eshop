package sk.metatim.eshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class OrderRequestDTO {

    private String orderID;
    private String customerID;
    private Map<String, Integer> orderedItems;
}
