package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    //Добавляем наш сервис
    private final ProductService productService;

    // по переходу на локальный хост будет вызываться данный метод @GetMapping("/")
    //Создаем model - это нужно для того чтобы передавать какие либо параметры в шаблонизатор и мы можем работать с данными которые мы передаем из контроллера
    //"products" - это ключ. productService - список всех товаров
    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", productService.listProducts());
        return "products";
    }

    //Создаем метод для просмотра подробной инфо о товаре
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}


//Final - потому что Spring сразу же при создании бина будет его инжектить
//@PathVariable - показывает как мы получаем данный аргумент то есть данную переменную