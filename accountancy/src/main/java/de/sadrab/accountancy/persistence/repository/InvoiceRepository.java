package de.sadrab.accountancy.persistence.repository;

import de.sadrab.accountancy.persistence.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    Invoice save(Invoice invoice);
}
