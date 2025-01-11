package com.inyeccion_dependencias.factura.models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Invoice {

    @Autowired
    private Client client;
    @Value("${invoice.description}")
    private String description;

    @Autowired
    //@Qualifier("itemsInvoiceOffice")
    private List<Item> items;

    @PostConstruct
    public void init() {
        System.out.println("Creando el componente de la factura");
        setDescription(getDescription().concat(" comprado por ".
                concat(client.getName()).concat(" " + client.getLastname())));
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        return items.stream()
                .map(item -> item.getImporte())
                .reduce(0, Integer::sum);
    }
}
