package com.bolditsin.finalwebstore.DAO;

import com.bolditsin.finalwebstore.entities.Product;
import com.bolditsin.finalwebstore.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    private static int PRODUCT_COUNT;
    private List<Product> products;
    {
        products= new ArrayList<>();
        products.add(new Product(++PRODUCT_COUNT,"Motherboard","Injection plate"));
        products.add(new Product(++PRODUCT_COUNT,"CPU","Heat Machine"));
        products.add(new Product(++PRODUCT_COUNT,"Graphics card", "Deficit"));
    }
    public List<Product> index(){
        return products;
    }

    public Product showProduct(int id){
        return products.stream().filter(user -> user.getId()== id).findAny().orElse(null);
    }

    public void save(Product product){
        product.setId(++PRODUCT_COUNT);
        products.add(product);
    }
    public void update(int id, Product updatedProduct){
        Product productToBeUpdated = showProduct(id);
        productToBeUpdated.setTitle(updatedProduct.getTitle());
    }
}
