package br.com.rsfot.vollmed.controller;

import br.com.rsfot.vollmed.domain.patient.*;
import br.com.rsfot.vollmed.infra.personalized.exception.PatientNotFoundException;
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
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping("/patients")
    @Transactional
    public ResponseEntity<PatientCompleteDetails> create(@Valid @RequestBody NewPatientRequest newPatientRequest,
                                                         UriComponentsBuilder uriComponentsBuilder) {
        Patient patient = newPatientRequest.toModel();
        patientRepository.save(patient);

        URI uri = uriComponentsBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
        var patientCompleteDetails = new PatientCompleteDetails(patient);

        return ResponseEntity.created(uri).body(patientCompleteDetails);
    }

    @GetMapping("/patients")
    public ResponseEntity<Page<PatientResponse>> list(@PageableDefault(sort = {"name"}) Pageable pageable) {
        return ResponseEntity.ok(patientRepository.findAllByActiveTrue(pageable).map(PatientResponse::new));
    }

    @PutMapping("/patient/{id}")
    @Transactional
    public ResponseEntity<PatientCompleteDetails> update(@PathVariable("id") Long id, @Valid @RequestBody UpdatePatientRequest updatePatientRequest) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
        updatePatientRequest.updatePatient(patient);
        return ResponseEntity.ok(new PatientCompleteDetails(patient));
    }

    @DeleteMapping("/patient/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException(id));
        patient.inactivate();
        return ResponseEntity.noContent().build();
    }

}
