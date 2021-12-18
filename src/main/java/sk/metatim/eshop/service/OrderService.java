package sk.metatim.eshop.service;

import sk.metatim.eshop.dto.order.GetOrderResponseDTO;
import sk.metatim.eshop.dto.order.OrderRequestDTO;
import sk.metatim.eshop.dto.order.OrderResponseDTO;

public interface OrderService {

    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO);

    public GetOrderResponseDTO getOrder(String orderID);

    public boolean updateOrder(String orderID, OrderRequestDTO orderRequestDTO);

    public void deleteOrder(String orderID);

}
