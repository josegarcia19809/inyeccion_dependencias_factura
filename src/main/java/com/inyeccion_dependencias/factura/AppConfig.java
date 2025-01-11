package com.inyeccion_dependencias.factura;

import com.inyeccion_dependencias.factura.models.Item;
import com.inyeccion_dependencias.factura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {
    @Bean
    List<Item> itemsInvoice() {
        Product product1 = new Product("Cámara Sony", 800);
        Product product2 = new Product("Bicicleta Bianchi", 1200);
        return Arrays.asList(
                new Item(product1, 2),
                new Item(product2, 4));
    }
}
