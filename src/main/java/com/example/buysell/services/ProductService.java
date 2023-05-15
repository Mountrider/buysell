package com.example.buysell.services;

import com.example.buysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    //Создаем список товаров
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product(++ID, "Playstation 5", "Simple description", 67000, "Chisinau", "Mihai"));
        products.add(new Product(++ID, "Iphone 8", "Simple description", 24000, "Balti", "Alexandru"));
    }

    public List<Product> listProducts() {
        return products;
    }

    //Добавляем в наш список товар
    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    //Удаляем товар передавя id
    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
//++ID При добавлении нового товара id будет увеличиваться