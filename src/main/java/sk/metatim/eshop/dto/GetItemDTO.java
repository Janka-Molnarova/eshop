package sk.metatim.eshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetItemDTO {

    private String id;

    private String name;

    private Double price;

    private int itemCount;
}
