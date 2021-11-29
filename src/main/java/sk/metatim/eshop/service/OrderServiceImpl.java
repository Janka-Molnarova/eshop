package sk.metatim.eshop.service;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.persistence.ItemRepository;
import sk.metatim.eshop.persistence.Order;
import sk.metatim.eshop.persistence.OrderRepository;
import sk.metatim.eshop.utils.OrderConverter;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderConverter orderConverter;

    @Override
    public void addOrder(OrderRequestDTO orderRequestDTO) {
        orderRequestDTO.getOrderedIds().stream()


        Order order = orderConverter.convertDtoToEntity(orderRequestDTO);
        order.getItems()

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
