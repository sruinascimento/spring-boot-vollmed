package br.com.rsfot.vollmed.doctor;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostMapping("/doctors")
    @Transactional
    public ResponseEntity<String> create(@Valid @RequestBody NewDoctorRequest newDoctorRequest) {
        Doctor newDoctor = newDoctorRequest.toModel();
        doctorRepository.save(newDoctor);
        return ResponseEntity.ok(new NewDoctorResponse(newDoctor).toString());
    }
}
