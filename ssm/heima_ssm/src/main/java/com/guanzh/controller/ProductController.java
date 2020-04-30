package com.guanzh.controller;


import com.guanzh.domain.Product;
import com.guanzh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //添加产品
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll";
    }

    //查询所有产品信息
    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public String findAll(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("productList",products);
        return "product-list";
    }

    /*@RequestMapping("/findAll")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }*/


}
