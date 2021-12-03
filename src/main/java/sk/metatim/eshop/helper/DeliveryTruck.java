package sk.metatim.eshop.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.metatim.eshop.persistence.item.Item;
import sk.metatim.eshop.persistence.item.ItemRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DeliveryTruck {

    @Autowired
    ItemRepository itemRepository;

    public void deliver(Item item, Item... items) {

        List<Item> deliveredItems = new ArrayList<>();
        deliveredItems.add(item);
        deliveredItems.addAll(Arrays.asList(items));

        deliveredItems
                .forEach(i -> {
                    Item dbItem = itemRepository.findByName(i.getName());
                    dbItem.setItemCount(dbItem.getItemCount() + i.getItemCount());
                    itemRepository.save(dbItem);
                });
    }
}
