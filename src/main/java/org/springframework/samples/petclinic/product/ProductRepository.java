package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    @Query("SELECT prodtype FROM ProductType prodtype")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    @Query("SELECT prodType FROM ProductType prodType WHERE prodType.name = ?1")
    Product findByName(String name);
    @Query("SELECT prod FROM Product prod WHERE prod.price < ?1")
    List<Product> findProductsCheaperThan(double price);
    Product save(Product p);
}
