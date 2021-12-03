package sk.metatim.eshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.metatim.eshop.dto.GetOrderResponseDTO;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.dto.OrderResponseDTO;
import sk.metatim.eshop.service.OrderService;

@RestController
public class OrderController {

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
    @PostMapping(value = "/addOrder")
    public OrderResponseDTO addOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return eshopService.addOrder(orderRequestDTO);
    }

    @GetMapping(value = "/getOrder/{orderID}")
    public GetOrderResponseDTO getOrder(@PathVariable String orderID) {
        return eshopService.getOrdersOfUser(orderID);
    }

    @PostMapping(value = "/updateOrder/{orderID}")
    public void updateOrder(@PathVariable String orderID, @RequestBody OrderRequestDTO orderRequestDTO) {
        eshopService.updateOrder(orderID, orderRequestDTO);
    }

    @PostMapping(value = "/deleteOrder/{orderID}")
    public void deleteOrder(@PathVariable String orderID) {
        eshopService.deleteOrder(orderID);
    }


}
