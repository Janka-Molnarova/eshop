package sk.metatim.eshop.service;

import sk.metatim.eshop.dto.GetOrderResponseDTO;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;

public interface OrderService {

    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO);

    public GetOrderResponseDTO getOrder(String orderID);

    public boolean updateOrder(String orderID, OrderRequestDTO orderRequestDTO);

    public void deleteOrder(String orderID);

}
