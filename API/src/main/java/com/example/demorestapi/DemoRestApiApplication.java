package com.example.demorestapi;

import com.example.demorestapi.entities.Product;
import com.example.demorestapi.metier.ProductMetier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRestApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(ProductMetier productMetier){
        return args -> {
            productMetier.save(new Product(null, "Ordinnateur HP 220", 100, 25, false, false));
            productMetier.save(new Product(null, "Impriment HP Z20", 20, 5, true, false));
            productMetier.save(new Product(null, "PC DELL core7", 150, 10, false, false));
            productMetier.save(new Product(null, "TV LED 7898", 70, 15, true, true));
            productMetier.save(new Product(null, "Home Cinema Samsung T78", 100, 25, false, false));
            productMetier.save(new Product(null, "Desktop HP Pavillon", 200, 5, true, true));
            productMetier.save(new Product(null, "MacBook pro", 400, 15, true, true));
            productMetier.save(new Product(null, "Dell Generate", 100, 12, true, true));
            productMetier.save(new Product(null, "Samsung G20", 240, 15, true, true));
            productMetier.save(new Product(null, "Desktop HP EliteBook", 150, 15, true, true));
            productMetier.save(new Product(null, "Desktop HP ProBook", 310, 18, true, true));
            productMetier.save(new Product(null, "Accer Magnum", 600, 17, true, true));
            productMetier.save(new Product(null, "Toshiba Learn", 300, 15, true, true));
            //productMetier.getAllList().forEach(System.out::println);
        };
    }

}
