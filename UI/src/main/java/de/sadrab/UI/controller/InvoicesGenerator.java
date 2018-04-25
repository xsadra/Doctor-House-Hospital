package de.sadrab.UI.controller;

import de.sadrab.UI.model.Invoice;
import de.sadrab.UI.model.LocalInvoice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoicesGenerator {

    @Value("${accountancy.invoices.url}")
    private String accountancyUrl;

    private RestTemplate restTemplate;

    public InvoicesGenerator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private DateTimeFormatter formatter;

    public List<LocalInvoice> getInvoices() {
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        List<Invoice> invoices = Arrays.asList(restTemplate.getForObject(accountancyUrl, Invoice[].class));
        return invoices.stream()
                .map(invoice -> {
                    LocalInvoice localInvoice = new LocalInvoice();
                    localInvoice.setName(invoice.getPatient().getName());
                    localInvoice.setIllness(invoice.getPatient().getIllness());
                    localInvoice.setCost(invoice.getCost().toString() + " $");
                    localInvoice.setTime(formatter.format(invoice.getLastTimeUsed()).toString());
                    return localInvoice;
                })
                .collect(Collectors.toList());
    }
}
