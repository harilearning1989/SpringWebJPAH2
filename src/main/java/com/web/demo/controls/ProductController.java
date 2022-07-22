package com.web.demo.controls;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "", "product" })
public class ProductController {

    @RequestMapping(value = "/prodList",method = RequestMethod.GET)
    public String productsList() {
        return "products";
    }

}