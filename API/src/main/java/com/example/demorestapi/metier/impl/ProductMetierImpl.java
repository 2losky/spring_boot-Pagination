package com.example.demorestapi.metier.impl;

import com.example.demorestapi.dao.ProductRepository;
import com.example.demorestapi.entities.Product;
import com.example.demorestapi.metier.ProductMetier;
import com.example.demorestapi.utils.ErrorMessage;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
@AllArgsConstructor
public class ProductMetierImpl implements ProductMetier {

    private ProductRepository productRepository;

    @Override
    public Product save(Product product) throws Exception {
        if(product == null)
            throw new Exception(ErrorMessage.NULL_ARGS);
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) throws Exception {
        if(product == null)
            throw new Exception(ErrorMessage.NULL_ARGS);
        if(!productRepository.existsById(product.getId()))
            throw new Exception(ErrorMessage.NOT_FOUND);
        return productRepository.saveAndFlush(product);
    }

    @Override
    public boolean delete(Long id) throws Exception {
        if(id == null)
            throw new Exception(ErrorMessage.NULL_ARGS);
        if(!productRepository.existsById(id))
            throw new Exception(ErrorMessage.NOT_FOUND);
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Product getProductById(Long id) throws Exception {
        if(id == null)
            throw new Exception(ErrorMessage.NULL_ARGS);
        if(!productRepository.existsById(id))
            throw new Exception(ErrorMessage.NOT_FOUND);
        return productRepository.getProductsById(id);
    }

    @Override
    public Page<Product> getAllList(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.getAllList(pageable);
    }

    @Override
    public List<Product> findAllList() {
        return productRepository.findAll();
    }


}
