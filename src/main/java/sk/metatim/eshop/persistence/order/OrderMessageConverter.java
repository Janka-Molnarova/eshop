package sk.metatim.eshop.persistence.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sk.metatim.eshop.helper.OrderResponseMessage;

import javax.persistence.AttributeConverter;

public class OrderMessageConverter implements AttributeConverter<OrderResponseMessage, String> {

    @Override
    public String convertToDatabaseColumn(OrderResponseMessage orderResponseMessage) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(orderResponseMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public OrderResponseMessage convertToEntityAttribute(String json) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, OrderResponseMessage.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}