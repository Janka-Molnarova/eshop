package sk.metatim.eshop.persistence.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sk.metatim.eshop.helper.DeliveryTruck;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Map;

@Converter
public class OrderedItemsConverter implements AttributeConverter<Map<String, Integer>, String> {

    private static final Logger logger = LogManager.getLogger(OrderedItemsConverter.class);

    @Override
    public String convertToDatabaseColumn(Map<String, Integer> orderedItems) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(orderedItems);
        } catch (JsonProcessingException e) {
            logger.error("Error converting value to DB column: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Map<String, Integer> convertToEntityAttribute(String jsonString) {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Integer> itemsMap;
        try {
            itemsMap = objectMapper.readValue(jsonString, Map.class); //todo: handle type issues
            return itemsMap;
        } catch (JsonProcessingException e) {
            logger.error("Error converting value to entity attribute: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
