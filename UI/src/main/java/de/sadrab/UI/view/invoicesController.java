package de.sadrab.UI.view;

import de.sadrab.UI.controller.InvoicesGenerator;
import de.sadrab.UI.model.LocalInvoice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class invoicesController {

    private InvoicesGenerator invoicesGenerator;

    public invoicesController(InvoicesGenerator invoicesGenerator) {
        this.invoicesGenerator = invoicesGenerator;
    }

    @ModelAttribute("invoices")
    List<LocalInvoice> invoices() {
        return invoicesGenerator.getInvoices();
    }

    @GetMapping
    String page() {
        return "invoices";
    }
}
