package sk.metatim.eshop.service;

import org.springframework.stereotype.Service;
import sk.metatim.eshop.dto.OrderRequestDTO;

@Service
public class OrderServiceImpl implements OrderService {

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
