package br.com.rsfot.vollmed.domain.appointment;

import java.time.LocalDateTime;

public record AppointmentCompleteDetails (
        Long id,
        String patientName,
        String doctorName,
        LocalDateTime dateAppointment
) {
    public AppointmentCompleteDetails(Appointment appointment) {
        this(appointment.getId(),
                appointment.getPatient().getName(),
                appointment.getDoctor().getName(),
                appointment.getDateAppointment());
    }
}
