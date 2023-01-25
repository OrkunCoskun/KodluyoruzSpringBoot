package com.orkuncoskun.controller;

import com.orkuncoskun.bean.BeanConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class BeanController {

    @Autowired
    BeanConfig beanConfig;

    // http:/localhost:8080/bean/beanDto
    @GetMapping("/bean/beanDto") //url
    @ResponseBody //html olmadan direkt ekranda göstermeyi sağlar.
    public String getBeanDto() {
        return beanConfig.beanDto() + ".";
    }


}
