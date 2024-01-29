package br.com.rsfot.vollmed.doctor;

public record DoctorResponse(String name, String email, String crm, Especialty especialty) {
    public DoctorResponse(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
