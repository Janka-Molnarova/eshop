package sk.metatim.eshop.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Item {

    String itemID;

    @Setter
    String name;
    @Setter
    Double price;

    public Item(){
        this.itemID = UUID.randomUUID().toString();
    }
}
