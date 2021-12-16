package sk.metatim.eshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sk.metatim.eshop.controller.OrderController;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;
import sk.metatim.eshop.helper.DeliveryTruck;
import sk.metatim.eshop.persistence.item.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
public class EshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopApplication.class, args);
    }

    @Bean
    public CommandLineRunner runStuff(OrderController orderController, DeliveryTruck truck) {
        return args -> {

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
}
