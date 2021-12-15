package sk.metatim.eshop.persistence.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.metatim.eshop.helper.OrderResponseMessage;

import javax.persistence.AttributeConverter;

public class OrderMessageConverter implements AttributeConverter<OrderResponseMessage, String> {

    private static final Logger logger = LogManager.getLogger(OrderMessageConverter.class);

    @Override
    public String convertToDatabaseColumn(OrderResponseMessage orderResponseMessage) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(orderResponseMessage);
        } catch (JsonProcessingException e) {
            logger.error("Error converting value to DB column: " + e.getMessage());
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
            logger.error("Error converting value to entity attribute: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}