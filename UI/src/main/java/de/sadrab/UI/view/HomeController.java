package de.sadrab.UI.view;

import de.sadrab.UI.controller.PatientController;
import de.sadrab.UI.model.Patient;
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
    Patient patient() {
        return new Patient();
    }

    @PostMapping("/home")
    String newPatient(Patient patient) {
        patientController.addNewPatient(patient);
        return "redirect:/";
    }

    @GetMapping
    String page() {
        return "home";
    }
}
