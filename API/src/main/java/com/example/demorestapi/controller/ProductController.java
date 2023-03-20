package com.example.demorestapi.controller;

import com.example.demorestapi.entities.Product;
import com.example.demorestapi.metier.ProductMetier;
import com.example.demorestapi.utils.AppPage;
import com.example.demorestapi.utils.CustomPagination;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {


    private ProductMetier productMetier;

    @PostMapping(value = "/save")
    public Product save(@RequestBody Product product) throws Exception {
        return productMetier.save(product);
    }

    @PutMapping(value = "/update")
    public Product update(Product product) throws Exception {
        return productMetier.update(product);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        return productMetier.delete(id);
    }

    @GetMapping(value = "/find/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws Exception {
        return productMetier.getProductById(id);
    }

    /*
    * NOUS AVONS ICI DEUX EXEMPLE DE PAGINATIONS
    * UNE PAGINATION AVEC PAGEABLE DE SPRING ET
    * UNE PAGINATION PERSONNALISEE
    * */


    //On peut aussi utiliser les @Pathvariable au lieu des @RequestParam
    @GetMapping(value = "/list")
    public Page<Product> getAllList(@RequestParam(name = "page") int pageNumber, @RequestParam(name = "size") int pageSize) {
        return productMetier.getAllList(pageNumber, pageSize);
    }

    //On peut aussi utiliser les @Pathvariable au lieu des @RequestParam
    @GetMapping(value = "/pagination")
    public AppPage<Product> findAllList(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return CustomPagination.getAppPage(productMetier.findAllList(), page, size);

    }



}
