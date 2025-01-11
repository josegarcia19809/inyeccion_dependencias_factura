package com.inyeccion_dependencias.factura.controllers;

import com.inyeccion_dependencias.factura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private Invoice invoice;

    @RequestMapping("/show")
    public Invoice show() {
        return invoice;
    }
}
