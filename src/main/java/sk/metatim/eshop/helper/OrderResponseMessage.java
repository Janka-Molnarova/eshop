package sk.metatim.eshop.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OrderResponseMessage {

    private static Logger logger = LogManager.getLogger(OrderResponseMessage.class);

    public static final String OK = "OK";
    public static final String NOT_ENOUGH_ITEMS = "Not enough items.";
    public static final String DUPLICATE_ORDER = "Order already exists.";

    private String message;
    private String details;

    public OrderResponseMessage(String msg) {
        this.message = msg;
    }

    public String mapObjectoJson(Object o) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            logger.error("Error mapping object to JSON: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static OrderResponseMessage getOK() {
        return new OrderResponseMessage(OK);
    }
}
