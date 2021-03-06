package sk.metatim.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.metatim.eshop.dto.GetOrderResponseDTO;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;
import sk.metatim.eshop.helper.OrderResponseMessage;
import sk.metatim.eshop.persistence.item.Item;
import sk.metatim.eshop.persistence.item.ItemRepository;
import sk.metatim.eshop.persistence.order.Order;
import sk.metatim.eshop.persistence.order.OrderRepository;
import sk.metatim.eshop.utils.OrderConverter;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderConverter orderConverter;

    @Override
    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO) {

        OrderResponseDTO response = new OrderResponseDTO();
        response.setOrderID(orderRequestDTO.getOrderID());
        //duplicate order
        if (orderRepository.findByOrderId(orderRequestDTO.getOrderID()) != null) {
            response.setSuccess(false);
            OrderResponseMessage orm = new OrderResponseMessage();
            orm.setMessage(OrderResponseMessage.DUPLICATE_ORDER);
            response.setMessage(orm);
            return response;
        }

        //check if items are available
        Map<String, Integer> itemsNotPresent = orderRequestDTO.getOrderedItems().entrySet().stream()
                .map(e -> {
                    Item dbItem = itemRepository.findByName(e.getKey());
                    if (dbItem == null) { //non-existing item
                        e.setValue(0);
                        return e;
                    } else if (e.getValue() > dbItem.getItemCount()) {
                        e.setValue(dbItem.getItemCount());
                        return e;
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        //some items are not present
        if (itemsNotPresent.entrySet().size() > 0) {
            response.setSuccess(false);
            OrderResponseMessage orm = new OrderResponseMessage();
            orm.setMessage(OrderResponseMessage.NOT_ENOUGH_ITEMS);
            orm.setDetails(orm.mapObjectoJson(itemsNotPresent));
            response.setMessage(orm);
        } else { //everything is available
            response.setSuccess(true);
            response.setMessage(OrderResponseMessage.getOK());
            double price = orderRequestDTO.getOrderedItems().entrySet().stream()
                    .mapToDouble(e -> {
                        Item dbItem = itemRepository.findByName(e.getKey());
                        dbItem.setItemCount(dbItem.getItemCount() - e.getValue());
                        itemRepository.save(dbItem);
                        return e.getValue() * dbItem.getPrice();
                    })
                    .sum();
            response.setPrice(price);
        }

        storeOrder(response, orderRequestDTO);
        return response;
    }

    @Override
    public GetOrderResponseDTO getOrder(String orderID) {
        Order entity = orderRepository.findByOrderId(orderID);
        if (entity != null) {
            return orderConverter.convertEntityToGetDTO(entity);
        }
        return null;
    }

    @Override
    public boolean updateOrder(String orderID, OrderRequestDTO orderRequestDTO) {

        Order order = orderRepository.findByOrderId(orderID);

        if (order != null) {

            OrderConverter converter = new OrderConverter();
            order = converter.convertDtoToEntity(orderRequestDTO);

            orderRepository.save(order);
            return true;
        }

        return false;
    }

    @Override
    public void deleteOrder(String orderID) {
        Order entity = orderRepository.findByOrderId(orderID);
        if (entity != null) {
            orderRepository.delete(entity);
        }
    }

    private void storeOrder(OrderResponseDTO response, OrderRequestDTO request) {

        Order order = new Order();
        order.setOrderId(response.getOrderID());
        order.setSuccess(response.isSuccess());
        order.setMessage(response.getMessage());
        order.setCustomerId(request.getCustomerID());
        order.setPrice(response.getPrice());
        order.setItems(request.getOrderedItems());

        orderRepository.save(order);
    }

    @Override
    public List<GetOrderResponseDTO> getFailedOrders() {
        List<Order> enties = orderRepository.findAllBySuccessIsFalse();
        if (enties != null) {
            return orderConverter.convertEntitiesToGetDTOList(enties);
        }
        return null;
    }
}
