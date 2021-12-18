package sk.metatim.eshop.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.metatim.eshop.dto.order.GetOrderResponseDTO;
import sk.metatim.eshop.dto.order.OrderRequestDTO;
import sk.metatim.eshop.dto.order.OrderResponseDTO;
import sk.metatim.eshop.service.OrderService;

@RestController("/order")
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    public OrderService eshopService;

    //    {
    //        "orderId": "e3ae6e1a-b596-4386-82f0-071ff037dbd9",
    //        "customerId": "b7654084-676b-4ce3-993f-5457b8cdf6b3",
    //        "orderedItems": {
    //            "ponozky": 3,
    //            "tricko": 1
    //        }
    //    }
    @PostMapping(value = "/add")
    public OrderResponseDTO addOrder(@RequestBody OrderRequestDTO orderRequestDTO) {

        logger.info(String.format("Recieved request [%s][%s]",
                "/order/add",
                orderRequestDTO.toString()
        ));

        OrderResponseDTO response = eshopService.addOrder(orderRequestDTO);

        logger.info(String.format("Returning response for request [%s][%s]",
                "/order/add",
                response.toString()
        ));

        return response;
    }

    @GetMapping(value = "/get/{orderID}")
    public GetOrderResponseDTO getOrder(@PathVariable String orderID) {

        logger.info(String.format("Recieved request [%s][%s]",
                "/order/get",
                orderID
        ));

        GetOrderResponseDTO response = eshopService.getOrder(orderID);

        logger.info(String.format("Returning response for request [%s][%s]",
                "/order/get",
                response.toString()
        ));

        return response;
    }

    @PostMapping(value = "/update/{orderID}")
    public void updateOrder(@PathVariable String orderID, @RequestBody OrderRequestDTO orderRequestDTO) {

        logger.info(String.format("Recieved request [%s][OrderId:%s][%s]",
                "/order/update",
                orderID,
                orderRequestDTO.toString()
        ));
        eshopService.updateOrder(orderID, orderRequestDTO);
    }

    @PostMapping(value = "/delete/{orderID}")
    public void deleteOrder(@PathVariable String orderID) {

        logger.info(String.format("Recieved request [%s][%s]",
                "/order/delete",
                orderID
        ));
        eshopService.deleteOrder(orderID);
    }


}
