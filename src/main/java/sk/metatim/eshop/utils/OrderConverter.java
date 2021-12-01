package sk.metatim.eshop.utils;

import org.springframework.stereotype.Component;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;
import sk.metatim.eshop.persistence.Order;

@Component
public class OrderConverter {

    public Order convertDtoToEntity(OrderRequestDTO dto) {
        Order order = new Order();
        order.setOrderId(dto.getOrderID());
        order.setCustomerId(dto.getCustomerID());
        order.setItems(dto.getOrderedItems());
        return order;
    }

    public OrderResponseDTO convertEntityToDto(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setSuccess(order.isSuccess());
        dto.setMessage(order.getMessage());
        dto.setOrderID(order.getOrderId());
        dto.setPrice(order.getPrice());
        return dto;
    }


}
