package br.com.rsfot.vollmed.patient;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
}
