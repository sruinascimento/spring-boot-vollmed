package br.com.rsfot.vollmed.doctor;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/doctors")
    public Page<DoctorResponse> list(@PageableDefault(sort = {"name"}) Pageable pageable) {
        return doctorRepository.findAllByActiveTrue(pageable)
                .map(DoctorResponse::new);
    }

    @PutMapping("/doctors/{id}")
    @Transactional
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @Valid @RequestBody UpdateDoctorRequest updateDoctorRequest) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found by id: " + id));
        updateDoctorRequest.updateDoctor(doctor);

        doctorRepository.save(doctor);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/doctors/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found by id: " + id));
        doctor.inactivate();
        return ResponseEntity.ok().build();
    }
}
