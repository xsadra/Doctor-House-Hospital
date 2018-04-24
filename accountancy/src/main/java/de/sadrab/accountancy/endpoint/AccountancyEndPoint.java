package de.sadrab.accountancy.endpoint;

import de.sadrab.accountancy.controller.Cost;
import de.sadrab.accountancy.persistence.model.Invoice;
import de.sadrab.accountancy.persistence.model.Patient;
import de.sadrab.accountancy.persistence.repository.InvoiceRepository;
import de.sadrab.accountancy.persistence.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping
public class AccountancyEndPoint {

    private PatientRepository patientRepository;
    private InvoiceRepository invoiceRepository;
    private Cost cost;

    public AccountancyEndPoint(PatientRepository patientRepository, InvoiceRepository invoiceRepository, Cost cost) {
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
        this.cost = cost;
    }

    @PostMapping("/patients")
    void getPatient(@RequestBody Patient patient) {
        Patient savePatient = patientRepository.save(patient);
        Invoice invoice = newInvoice(savePatient);
        invoiceRepository.save(invoice);
    }

    private Invoice newInvoice(Patient patient) {
        Double cost = this.cost.getCost(patient);
        return new Invoice(cost, LocalDateTime.now(), patient);
    }

    @GetMapping("/invoices")
    List<Invoice> showInvoices(){
        return invoiceRepository.findAll();
    }
}
