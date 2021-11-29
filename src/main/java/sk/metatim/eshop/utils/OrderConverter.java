package sk.metatim.eshop.utils;

import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;
import sk.metatim.eshop.persistence.Order;

public class OrderConverter {

    public Order convertDtoToEntity(OrderRequestDTO dto) {
        Order order = new Order();
        order.setOrderId(dto.getOrderID());
        order.setCustomerId(dto.getCustomerID());
        order.setItems(dto.getOrderedIds().);
    }

    public OrderResponseDTO convertEntityToDto(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setSuccess(order.isSuccess());
        dto.setMessage(order.getMessage());
        dto.setOrderID(order.getOrderId());
        dto.setPrice(order.getPrice());
    }




}
