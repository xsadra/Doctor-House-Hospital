package de.sadrab.accountancy.endpoint;

import de.sadrab.accountancy.persistence.model.Invoice;
import de.sadrab.accountancy.persistence.model.Patient;
import de.sadrab.accountancy.persistence.repository.InvoiceRepository;
import de.sadrab.accountancy.persistence.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping
public class NurseryEndPoint {

    private PatientRepository patientRepository;
    private InvoiceRepository invoiceRepository;

    public NurseryEndPoint(PatientRepository patientRepository, InvoiceRepository invoiceRepository) {
        this.patientRepository = patientRepository;
        this.invoiceRepository = invoiceRepository;
    }

    @PostMapping("/patients")
    void getPatient(@RequestBody Patient patient) {
        System.out.printf("\nPatient: " + patient);
        Patient savePatient = patientRepository.save(patient);
        System.out.printf("\nsavePatient: " + savePatient);
        Invoice invoice = new Invoice(100.0, LocalDateTime.now(), savePatient);
        System.out.printf("\nInvoice: " + invoice);
        Invoice saveInvoice = invoiceRepository.save(invoice);
        System.out.printf("\nsaceInvoice: " + saveInvoice);
    }

    @GetMapping("/invoices")
    List<Invoice> showInvoices(){
        return invoiceRepository.findAll();
    }
}
