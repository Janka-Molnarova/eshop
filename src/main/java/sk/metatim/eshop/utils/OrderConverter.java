package sk.metatim.eshop.utils;

import org.springframework.stereotype.Component;
import sk.metatim.eshop.dto.order.GetOrderResponseDTO;
import sk.metatim.eshop.dto.order.OrderRequestDTO;
import sk.metatim.eshop.dto.order.OrderResponseDTO;
import sk.metatim.eshop.persistence.order.Order;

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
        dto.setOrderID(order.getOrderId());
        dto.setPrice(order.getPrice());
        dto.setMessage(order.getMessage());

        return dto;
    }

    public GetOrderResponseDTO convertEntityToGetDTO(Order order) {
        GetOrderResponseDTO dto = new GetOrderResponseDTO();
        dto.setId(Long.toString(order.getId()));
        dto.setSuccess(order.isSuccess());
        dto.setMessage(order.getMessage());
        dto.setOrderId(order.getOrderId());
        dto.setCustomerId(order.getCustomerId());
        dto.setItems(order.getItems());
        dto.setPrice(order.getPrice());

        return dto;
    }
}
