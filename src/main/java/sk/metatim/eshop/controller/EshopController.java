package sk.metatim.eshop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import sk.metatim.eshop.service.SaveDataService;

@RestController
public class EshopController {

    @Autowired
    public SaveDataService eshopService;



}
