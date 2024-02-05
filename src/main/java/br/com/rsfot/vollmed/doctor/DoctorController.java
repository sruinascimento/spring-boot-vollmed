package br.com.rsfot.vollmed.doctor;

import br.com.rsfot.vollmed.infra.personalizade.exception.DoctorNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class DoctorController {
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostMapping("/doctors")
    @Transactional
    public ResponseEntity<DoctorCompleteDetails> create(@Valid @RequestBody NewDoctorRequest newDoctorRequest,
                                                        UriComponentsBuilder uriComponentsBuilder) {
        Doctor newDoctor = newDoctorRequest.toModel();
        doctorRepository.save(newDoctor);

        URI uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(newDoctor.getId()).toUri();
        var doctorCompleteDetails = new DoctorCompleteDetails(newDoctor);

        return ResponseEntity.created(uri).body(doctorCompleteDetails);
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<DoctorCompleteDetails> details(@PathVariable("id") Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
        return ResponseEntity.ok(new DoctorCompleteDetails(doctor));
    }

    @GetMapping("/doctors")
    public ResponseEntity<Page<DoctorResponse>> list(@PageableDefault(sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok(doctorRepository.findAllByActiveTrue(pageable).map(DoctorResponse::new));
    }

    @PutMapping("/doctors/{id}")
    @Transactional
    public ResponseEntity<DoctorCompleteDetails> update(@PathVariable("id") Long id,
                                                        @Valid @RequestBody UpdateDoctorRequest updateDoctorRequest) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
        updateDoctorRequest.updateDoctor(doctor);
        return ResponseEntity.ok(new DoctorCompleteDetails(doctor));
    }

    @DeleteMapping("/doctors/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException(id));
        doctor.inactivate();
        return ResponseEntity.noContent().build();
    }
}
