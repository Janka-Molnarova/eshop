package sk.metatim.eshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import sk.metatim.eshop.controller.OrderController;
import sk.metatim.eshop.helper.DeliveryTruck;

@SpringBootApplication
@EnableScheduling
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
