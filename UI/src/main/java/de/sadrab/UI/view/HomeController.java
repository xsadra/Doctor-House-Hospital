package de.sadrab.UI.view;

import de.sadrab.UI.controller.PatientController;
import de.sadrab.UI.model.LocalPatient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    private PatientController patientController;

    public HomeController(PatientController patientController) {
        this.patientController = patientController;
    }

    @ModelAttribute("newPatient")
    LocalPatient patient() {
        return new LocalPatient();
    }

    @PostMapping("/")
    String newPatient(LocalPatient localPatient) {
        patientController.addNewPatient(localPatient);
        return "redirect:/";
    }

    @GetMapping
    String page() {
        return "home";
    }
}
