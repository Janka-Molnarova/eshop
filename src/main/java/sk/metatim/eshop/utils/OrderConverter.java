package sk.metatim.eshop.utils;

import org.springframework.stereotype.Component;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;
import sk.metatim.eshop.helper.OrderResponseMessage;
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
        dto.setOrderID(order.getOrderId());
        dto.setPrice(order.getPrice());

        OrderResponseMessage orm = new OrderResponseMessage();
        orm.setMessage(order.getMessage());
        dto.setMessage(orm);

        return dto;
    }


}
