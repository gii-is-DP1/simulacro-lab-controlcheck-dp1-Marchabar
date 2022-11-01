package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    private ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo){
        this.productRepo = productRepo;
    }
    public List<ProductType> findAllProductTypes(){
        return productRepo.findAllProductTypes();
    }
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProductByName(String name){
        return productRepo.findByName(name);
    }
    public List<Product> getProductsCheaperThan(double price) {
        return productRepo.findProductsCheaperThan(price);
    }

    public ProductType getProductType(String typeName) {
        return null;
    }

    public Product save(Product p){
        return null;       
    }

    
}
