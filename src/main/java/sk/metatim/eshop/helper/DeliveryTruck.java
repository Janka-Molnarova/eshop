package sk.metatim.eshop.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.metatim.eshop.persistence.item.Item;
import sk.metatim.eshop.persistence.item.ItemRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeliveryTruck {

    private static Logger logger = LogManager.getLogger(DeliveryTruck.class);

    @Autowired
    ItemRepository itemRepository;

    public void deliver(Item item, Item... items) {

        List<Item> deliveredItems = new ArrayList<>();
        deliveredItems.add(item);
        deliveredItems.addAll(Arrays.asList(items));

        logger.info(String.format("Delivery truck delivered the following items: [%s]",
                deliveredItems.stream()
                        .map(Item::getName)
                        .collect(Collectors.joining(","))
        ));

        deliveredItems.forEach(i -> {
            Item dbItem = itemRepository.findByName(i.getName());
            dbItem.setItemCount(dbItem.getItemCount() + i.getItemCount());
            itemRepository.save(dbItem);
        });
    }

    public void deliverMap(Map<String, Integer> itemMap) {

        logger.info(String.format("Delivery truck delivered the following items: [%s]",
                itemMap.entrySet().stream()
                        .map(Map.Entry::getKey)
                        .collect(Collectors.joining(","))
        ));

        itemMap.forEach((key, value) -> {
            Item dbItem = itemRepository.findByName(key);
            dbItem.setItemCount(dbItem.getItemCount() + value);
            itemRepository.save(dbItem);
        });
    }
}
