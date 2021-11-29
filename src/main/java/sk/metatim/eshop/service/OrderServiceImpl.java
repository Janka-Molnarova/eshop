package sk.metatim.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;
import sk.metatim.eshop.persistence.Item;
import sk.metatim.eshop.persistence.ItemRepository;
import sk.metatim.eshop.persistence.Order;
import sk.metatim.eshop.persistence.OrderRepository;
import sk.metatim.eshop.utils.OrderConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderConverter orderConverter;

    public static final String ORDER_OK = "OK";
    public static final String ORDER_NOT_ITEMS = "not enough items";

    @Override
    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO) {

        Map<String, Integer> orderMap = new HashMap<>();
        for (String item : orderRequestDTO.getOrderedItemNames()) {
            if (orderMap.containsKey(item)) {
                orderMap.put(item, orderMap.get(item) + 1);
            } else {
                orderMap.put(item, 1);
            }
        }

        AtomicBoolean allItemsPresent = new AtomicBoolean(true);
        orderMap.forEach((key, value) -> {
            Item itemFromDb = itemRepository.findByName(key);
            if (itemFromDb.getItemCount() >= value) {
                allItemsPresent.set(false);
            }
        });

        Order order = orderConverter.convertDtoToEntity(orderRequestDTO);

        if (allItemsPresent.get()) {

            order.setSuccess(true);
            order.setMessage(ORDER_OK);
            orderRepository.save(order);
            return orderConverter.convertEntityToDto(order);

        } else {

            order.setSuccess(false);
            order.setMessage(ORDER_NOT_ITEMS);
            return orderConverter.convertEntityToDto(order);
        }
    }

    @Override
    public OrderRequestDTO getOrdersOfUser(String orderID) {
        return null;
    }

    @Override
    public void updateOrder(String orderID, OrderRequestDTO orderRequestDTO) {

    }

    @Override
    public void deleteOrder(String orderID) {

    }
}
