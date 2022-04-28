package sk.metatim.eshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.Transactional;
import sk.metatim.eshop.controller.OrderController;
import sk.metatim.eshop.helper.DeliveryTruck;
import sk.metatim.eshop.persistence.item.Item;
import sk.metatim.eshop.persistence.item.ItemRepository;
import sk.metatim.eshop.persistence.item.Sizes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableScheduling
public class EshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }

    @Bean
    public CommandLineRunner runStuff(OrderController orderController, DeliveryTruck truck, ItemRepository itemRepo) {
        return args -> {

            Item testItem = new Item();
            testItem.setItemCount(100);
            testItem.setName("test item");
            testItem.setPrice(30.00);

            Sizes sizes1 = new Sizes();
            sizes1.setItemSize("M");
            sizes1.setItem(testItem);
            Sizes sizes2 = new Sizes();
            sizes2.setItemSize("L");
            sizes2.setItem(testItem);
            Sizes sizes3 = new Sizes();
            sizes3.setItemSize("XL");
            sizes3.setItem(testItem);
            Sizes sizes4 = new Sizes();
            sizes4.setItemSize("XXL");
            sizes4.setItem(testItem);

            testItem.setSizes(Arrays.asList(sizes1, sizes2, sizes3, sizes4));

            itemRepo.save(testItem);

            getData(itemRepo);

//            Map<String, Integer> deliveredItems = new HashMap<>();
//            deliveredItems.put("tricko", 10);
//            deliveredItems.put("ponozky", 10);
//
//            truck.deliver(deliveredItems);
//
//            OrderRequestDTO dto = new OrderRequestDTO();
//            dto.setOrderID(UUID.randomUUID().toString());
//            dto.setCustomerID("b7654084-676b-4ce3-993f-5457b8cdf6b3");
//            Map<String, Integer> items = new HashMap<>();
//            items.put("ponozky", 5);
//            items.put("tricko", 3);
//            dto.setOrderedItems(items);
//
//            OrderResponseDTO response = orderController.addOrder(dto);
        };
    }

    @Transactional
    void getData(@Autowired ItemRepository itemRepo){
        List<Item> items = itemRepo.findAll();
        System.out.println("Sizes available:\n");
        items.forEach(item -> {
            List<String> sizes = item.getSizes().stream()
                    .map(Sizes::getItemSize)
                    .collect(Collectors.toList());
            System.out.printf("%s -> %s\n", item.getName(), String.join("/", sizes));
        });
    }
}
