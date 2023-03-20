package com.example.demorestapi.dao;

import com.example.demorestapi.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository  extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.id = :id")
    Product getProductsById(@Param("id") Long id);

    @Query("select p from Product p")
    Page<Product> getAllList(Pageable pageable);



}
