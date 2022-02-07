package sk.metatim.eshop.jobs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import sk.metatim.eshop.dto.GetItemDTO;
import sk.metatim.eshop.dto.GetOrderResponseDTO;
import sk.metatim.eshop.jobs.service.NewOrdersService;
import sk.metatim.eshop.service.ItemService;
import sk.metatim.eshop.service.OrderService;

import java.util.List;

@Configuration
public class OrdersItemsJobs {

    private static final Logger logger = LogManager.getLogger(OrdersItemsJobs.class);

    @Autowired
    NewOrdersService newOrdersService;

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @Scheduled(cron = "*/3 * * * * *")
    public void pingMe(){
        logger.info("ping");
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void failedOrders() {
        List<GetOrderResponseDTO> failedOrders = orderService.getFailedOrders();
        logger.debug("Neuspesne objednavky: " + failedOrders);
    }

    @Scheduled(cron = "*/3 * * * * *")
    public void fewPiecesInWarehouse() {
        List<GetItemDTO> items = itemService.getFewPiecesInWarehouse(3);
        logger.debug("Na sklade je uz len zopar ks z poloziek: " + items);
    }
}
