package pl.mwrobel.productcatalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog(){
        this.products = new ArrayList<>();

    }

    public List<Product> allProducts(){
        return products;
    }

    public String addProduct(String name, String desc){
        Product newOne = new Product(
                UUID.randomUUID(),
                name,
                desc);

        products.add(newOne);

        return newOne.getId();
    }

    public Product loadById(String productId){
        return null;
    }

}
