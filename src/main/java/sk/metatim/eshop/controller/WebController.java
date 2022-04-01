package sk.metatim.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/shop")
public class WebController {

    @RequestMapping("/home")
    public String home(){
        return "index";
    }
}
