package com.inyeccion_dependencias.factura;

import com.inyeccion_dependencias.factura.models.Item;
import com.inyeccion_dependencias.factura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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


    @Bean
    @Primary
    List<Item> itemsInvoiceOffice() {
        Product p1 = new Product("Monitor Asus 24", 700);
        Product p2 = new Product("Notebook Razer", 2400);
        Product p3 = new Product("Impresora HP", 800);
        Product p4 = new Product("Escritorio Oficina", 900);
        return Arrays.asList(new Item(p1, 4), new Item(p2, 6), new Item(p3, 1), new Item(p4, 4));
    }
}
