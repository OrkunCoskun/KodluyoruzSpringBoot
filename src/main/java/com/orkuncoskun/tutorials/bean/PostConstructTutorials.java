package com.orkuncoskun.tutorials.bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class PostConstructTutorials {

//    @Autowired
//    Logger LOG;

    //parametresiz consturctor
//    public PostConstructTutorials() {
//        LOG.info("Log info çağırıldı");
//    }

    //bean henüz başlamadığından null pointer exception alıyoruz ve burada bağımlılığı encejte edemiyoruz.
    //Görevi: Bir bean nesnesi oluşturulduğunda hemen oluşur.
//    @PostConstruct
//    public void init() {
//        LOG.info("Log info çağırıldı");
//    }

//    public static void main(String[] args) {
//        PostConstructTutorials beanController = new PostConstructTutorials();
//        System.out.println(beanController);
//    }
}
