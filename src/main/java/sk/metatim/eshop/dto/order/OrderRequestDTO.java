package sk.metatim.eshop.dto.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class OrderRequestDTO {

    private String orderID;
    private String customerID;
    private Map<String, Integer> orderedItems;
}
