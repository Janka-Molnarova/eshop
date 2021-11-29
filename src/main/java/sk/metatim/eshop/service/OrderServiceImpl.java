package sk.metatim.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.persistence.ItemRepository;
import sk.metatim.eshop.persistence.Order;
import sk.metatim.eshop.persistence.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void addOrder(OrderRequestDTO orderRequestDTO) {


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
