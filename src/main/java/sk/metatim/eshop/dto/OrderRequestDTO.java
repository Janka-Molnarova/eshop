package sk.metatim.eshop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {

    private String orderID;
    private String customerID;
    private List<String> orderedItemNames;
}
