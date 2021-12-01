package sk.metatim.eshop.service;

import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;

public interface OrderService {

    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO);

    public OrderRequestDTO getOrdersOfUser(String orderID);

    public void updateOrder(String orderID, OrderRequestDTO orderRequestDTO);

    public void deleteOrder(String orderID);

}
