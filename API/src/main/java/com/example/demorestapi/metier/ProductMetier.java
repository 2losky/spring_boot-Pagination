package com.example.demorestapi.metier;

import com.example.demorestapi.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductMetier {
    Product save(Product product) throws Exception;
    Product update(Product product) throws Exception;
    boolean delete(Long id) throws Exception;
    Product getProductById(Long id) throws Exception;
    Page<Product> getAllList(int pageNumber, int pageSize);
    List<Product> findAllList();
}
