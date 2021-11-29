package sk.metatim.eshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.metatim.eshop.dto.OrderRequestDTO;
import sk.metatim.eshop.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    public OrderService eshopService;

    @PostMapping(value = "/addOrder")
    public void addOrder(OrderRequestDTO orderRequestDTO) {
        eshopService.addOrder(orderRequestDTO);
    }

    @GetMapping(value = "/getOrder/{orderID}")
    public OrderRequestDTO getOrder(@PathVariable String orderID) {
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
