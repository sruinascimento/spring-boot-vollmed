package br.com.rsfot.vollmed.controller;

import br.com.rsfot.vollmed.domain.appointment.NewAppointmentRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppointmentController {

    @PostMapping("/appointments")
    public void create(@Valid @RequestBody NewAppointmentRequest newAppointment) {
        System.out.println(newAppointment);
    }
}
