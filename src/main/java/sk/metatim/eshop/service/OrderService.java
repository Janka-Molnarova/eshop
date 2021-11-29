package sk.metatim.eshop.service;

import sk.metatim.eshop.dto.OrderRequestDTO;

import java.util.List;

public interface OrderService {

    public void addOrder(OrderRequestDTO orderRequestDTO);

    public OrderRequestDTO getOrdersOfUser(String orderID);

    public void updateOrder(String orderID, OrderRequestDTO orderRequestDTO);

    public void deleteOrder(String orderID);

}
