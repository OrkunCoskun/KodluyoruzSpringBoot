package com.orkuncoskun.controller;

import com.orkuncoskun.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {
    //Ctrl+alt+L = formatter

    //option: root {}
    //http://localhost:8080
    @GetMapping({"/", "index"})
    public String index(){
        return "index";
    }

    //ResponseBody
    //http://localhost:8080/thymeleaf1
    @GetMapping("/thymeleaf1")
    //@ResponseBody
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    //Model
    //http://localhost:8080/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeLeaf2Model(Model model) {
        model.addAttribute("key_model1", "Ben Modelden geldim-1");
        model.addAttribute("key_model2", "Ben Modelden geldim-2");
        return "thymeleaf1";
    }

    //Model birden fazla göndermek
    //http://localhost:8080/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeLeaf3Model(Model model) {
        model.addAttribute("key_model1", "Ben Modelden geldim-1");
        model.addAttribute("key_model2", "Ben Modelden geldim-2");
        return "thymeleaf_file/thymeleaf3";
    }

    //http://localhost:8080/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeLeaf4Model(Model model) {
        model.addAttribute("key_model1", "Ben Modelden geldim-4");
        return "thymeleaf4";
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    //Model Object göndermek
    //http://localhost:8080/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeLeaf5ModelObject(Model model) {
        model.addAttribute("key_model1", "text");
        ProductDto productDto = ProductDto
                .builder()
                .productID(0L)
                .productName("Ürün adı")
                .productPrice(2500)
                .build();
        model.addAttribute("key_model2", productDto);
        return "thymeleaf5";
    }

    //Model Object List göndermek
    //http://localhost:8080/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeLeaf6ModelObjectList(Model model) {
        model.addAttribute("key_model1", "text");
        List<ProductDto> listem = new ArrayList<>();
        listem.add(ProductDto.builder().productID(1L).productName("Ürün adı1").productPrice(1500).build());
        listem.add(ProductDto.builder().productID(2L).productName("Ürün adı2").productPrice(2500).build());
        listem.add(ProductDto.builder().productID(3L).productName("Ürün adı3").productPrice(3500).build());
        listem.add(ProductDto.builder().productID(4L).productName("Ürün adı4").productPrice(4500).build());
        model.addAttribute("product_liste", listem);
        return "thymeleaf6";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Model Object göndermek
    //http://localhost:8080/thymeleaf7/4
    @GetMapping({"/thymeleaf7", "/thymeleaf7/{id}"})
    public String getThymeLeaf7ModelObject(Model model, @PathVariable(name = "id", required = false) Long id) {
        if(id!=null) {
            model.addAttribute("key_model1", "id: " + id);
        } else {
            model.addAttribute("key_model1", "id bulunamadı");
        }
        return "thymeleaf7";
    }
}
