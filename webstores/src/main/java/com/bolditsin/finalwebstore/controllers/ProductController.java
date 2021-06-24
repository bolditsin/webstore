package com.bolditsin.finalwebstore.controllers;

import com.bolditsin.finalwebstore.DAO.ProductDAO;
import com.bolditsin.finalwebstore.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductDAO productDAO;

    public ProductController(ProductDAO productDAO){
        this.productDAO= productDAO;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("products", productDAO.index());
        return "products/index";
    }
    @GetMapping("/{id}")
    public String showProducts(@PathVariable("id") int id, Model model){
        model.addAttribute("product",productDAO.showProduct(id));
        return "products/showproduct";
    }
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());

        return "products/new";
    }
    @PostMapping
    public String create(@ModelAttribute("product") Product product){
        productDAO.save(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("product", productDAO.showProduct(id));
        return "products/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") Product product, @PathVariable("id") int id){
        productDAO.update(id, product);
        return "redirect:/products";
    }

}
